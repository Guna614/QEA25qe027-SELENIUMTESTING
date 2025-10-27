package practice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Automates YouTube Shorts:
 * 1) Opens YouTube Shorts
 * 2) Waits for each short to finish (100%)
 * 3) Navigates to next short
 * 4) Repeats for N shorts
 */
public class YouTubeShortsRunner {

    public static void main(String[] args) {
        YouTubeShortsRunner r = new YouTubeShortsRunner();
        r.runShorts(10); // play 10 shorts end-to-end
    }

    public void runShorts(int howMany) {
        ChromeOptions options = new ChromeOptions();
        // Optional hardening for autoplay & stability:
        options.addArguments("--autoplay-policy=no-user-gesture-required");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // 1) Open YouTube and go straight to Shorts (most reliable)
            driver.get("https://www.youtube.com/");
            dismissConsentIfPresent(driver); // optional, handles cookie/consent banners
            driver.navigate().to("https://www.youtube.com/shorts");

            // 2) Wait for a Shorts video element to be present
            wait.until(d -> ((JavascriptExecutor) d).executeScript(
                    "return !!document.querySelector('ytd-shorts video, video.html5-main-video');"
            ).equals(Boolean.TRUE));

            // 3) Loop through shorts
            for (int i = 1; i <= howMany; i++) {
                System.out.println(">> Playing short " + i + " of " + howMany);

                // Ensure video is ready and playing
                ensureVideoPlaying(driver);

                // Wait until this short is fully completed (100%)
                boolean ended = waitForShortToFinish(driver, Duration.ofSeconds(180)); // 3-minute safety cap
                if (!ended) {
                    System.out.println("   - Timed out waiting for completion. Proceeding to next.");
                } else {
                    System.out.println("   - Completed.");
                }

                if (i < howMany) {
                    // Go to next short (try Next button; fallback to ArrowDown)
                    goToNextShort(driver, wait);
                    // Wait for the next short (URL or video identity) to change
                    waitForNewShortToLoad(driver, wait);
                }
            }

        } finally {
            // driver.quit(); // Uncomment to close browser automatically
        }
    }

    /** Attempt to dismiss cookie/consent dialog if present (best effort). */
    private void dismissConsentIfPresent(WebDriver driver) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Try common buttons: "I agree" / "Accept all" / "Agree"
            By consentBtn = By.xpath("//button[contains(., 'I agree') or contains(., 'Agree') or contains(., 'Accept')]");
            WebElement btn = shortWait.until(ExpectedConditions.presenceOfElementLocated(consentBtn));
            btn.click();
        } catch (Exception ignore) {
            // Not present; continue
        }
    }

    /** Ensure a Shorts video exists, metadata is loaded, and it is playing. */
    private void ensureVideoPlaying(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait for metadata (duration) to be available
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> {
            Map<String, Object> info = getVideoInfo(js);
            if (!(Boolean) info.get("found")) return false;
            Number duration = (Number) info.get("duration");
            Number readyState = (Number) info.get("readyState");
            return duration.doubleValue() > 0 && readyState.intValue() >= 2; // HAVE_CURRENT_DATA
        });

        // Try to play if paused
        js.executeScript(
                "const v = document.querySelector('ytd-shorts video, video.html5-main-video');" +
                "if (v) { try { v.muted = true; v.play().catch(()=>{}); } catch(e){} }"
        );
    }

    /**
     * Poll the HTML5 video element until it ends (ended==true or currentTime/duration >= 99%).
     * Returns true if completed, false if timed out.
     */
    private boolean waitForShortToFinish(WebDriver driver, Duration timeout) {
        long deadline = System.currentTimeMillis() + timeout.toMillis();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (System.currentTimeMillis() < deadline) {
            Map<String, Object> info = getVideoInfo(js);

            if (!(Boolean) info.get("found")) {
                sleep(300);
                continue;
            }

            double t = ((Number) info.get("currentTime")).doubleValue();
            double d = ((Number) info.get("duration")).doubleValue();
            boolean ended = Boolean.TRUE.equals(info.get("ended"));

            if (ended) return true;
            if (d > 0 && t >= d * 0.999) return true;

            // Keep it playing in case it paused
            js.executeScript(
                "const v = document.querySelector('ytd-shorts video, video.html5-main-video');" +
                "if (v && v.paused) { try { v.play().catch(()=>{}); } catch(e){} }"
            );

            sleep(500);
        }
        return false;
    }

    /** Move to the next short via UI button or ArrowDown fallback. */
    private void goToNextShort(WebDriver driver, WebDriverWait wait) {
        // Primary: click the "Next" button in Shorts player if available
        try {
            By nextBtn = By.cssSelector("ytd-shorts tp-yt-paper-icon-button[aria-label='Next'], " +
                                        "ytd-reel-player-header-renderer tp-yt-paper-icon-button[aria-label='Next']");
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
            btn.click();
            return;
        } catch (Exception ignore) { }

        // Fallback: send ArrowDown on body to navigate to next short
        try {
            WebElement body = driver.findElement(By.tagName("body"));
            body.sendKeys(Keys.ARROW_DOWN);
        } catch (Exception e) {
            // Last resort: scroll a bit (YouTube Shorts usually snaps to next)
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        }
    }

    /** Wait until a new short is loaded (based on URL videoId change or currentTime reset). */
    private void waitForNewShortToLoad(WebDriver driver, WebDriverWait wait) {
        String beforeUrl = driver.getCurrentUrl();

        // Prefer URL change (Shorts URLs include /shorts/{videoId})
        try {
            wait.withTimeout(Duration.ofSeconds(10)).until((ExpectedCondition<Boolean>) d -> {
                String now = d.getCurrentUrl();
                return now != null && !now.equals(beforeUrl);
            });
            return;
        } catch (Exception ignore) { }

        // Fallback: wait for currentTime to reset near zero
        try {
            wait.withTimeout(Duration.ofSeconds(10)).until(d -> {
                Map<String, Object> info = getVideoInfo((JavascriptExecutor) d);
                if (!(Boolean) info.get("found")) return false;
                double t = ((Number) info.get("currentTime")).doubleValue();
                Number rs = (Number) info.get("readyState");
                return rs.intValue() >= 2 && t < 0.5;
            });
        } catch (Exception ignore) { }
    }

    /** Read key properties from the Shorts <video> element via JS. */
    @SuppressWarnings("unchecked")
    private Map<String, Object> getVideoInfo(JavascriptExecutor js) {
        Object result = js.executeScript(
            "const v = document.querySelector('ytd-shorts video, video.html5-main-video');" +
            "if (!v) return {found:false};" +
            "return {" +
            "  found: true," +
            "  currentTime: Number(v.currentTime||0)," +
            "  duration: Number(v.duration||0)," +
            "  ended: Boolean(v.ended||false)," +
            "  paused: Boolean(v.paused||false)," +
            "  readyState: Number(v.readyState||0)" +
            "};"
        );
        return (Map<String, Object>) result;
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) { }
    }

    /* ============================
       OPTIONAL: Search first, then open Shorts for that topic
       ============================ */
    public void openShortsForQuery(WebDriver driver, String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.youtube.com/");
        dismissConsentIfPresent(driver);

        // Search
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("search_query")));
        search.clear();
        search.sendKeys(query);
        search.sendKeys(Keys.ENTER);

        // Click any Shorts result (first matching /shorts/ link on the results page)
        By firstShort = By.cssSelector("a[href*='/shorts/']");
        WebElement shortLink = wait.until(ExpectedConditions.elementToBeClickable(firstShort));
        shortLink.click();

        // Now you're in Shorts view
        wait.until(d -> ((JavascriptExecutor) d).executeScript(
                "return !!document.querySelector('ytd-shorts video, video.html5-main-video');"
        ).equals(Boolean.TRUE));
    }
}