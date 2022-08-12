package main.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CoreTest {
    protected Playwright driver;
    protected Browser chrome;
    protected BrowserContext incognitoTab;
    protected Page browser;

    @BeforeClass
    public void openBrowser() {
        driver = Playwright.create();
        chrome = driver.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        incognitoTab = chrome.newContext(new Browser.NewContextOptions().setViewportSize(1620, 1080));
        browser = incognitoTab.newPage();
    }

    @AfterClass
    public void closeBrowser() {
        browser.close();
        incognitoTab.close();
        chrome.close();
        driver.close();
    }

    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(50).setChannel("chrome"));
//            Page page = browser.newPage();
//            page.navigate("http://whatsmyuseragent.org/");
//            page.close();
//        }

//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(1000));
//        BrowserContext browserOne = browser.newContext(new Browser.NewContextOptions().setViewportSize(1620, 1080));
//        Page ema = browserOne.newPage();
//        ema.navigate("https://derm.m2perf.com/ema/ProviderLogin.action");
//
//        //MRNYSq59e4g7S
//        PlaywrightAssertions.assertThat(this.webApp).hasTitle("Demo Dermatology");
//        ema.locator("text=Apply Filters").waitFor();
//        System.out.println(ema.locator(LocateBy.cssText("a", "Home")).textContent());
//        System.out.println(ema.locator("//a").count());
//        ema.locator("text=Apply Filters");
//        IntStream.rangeClosed(1, 5).mapToObj(i -> ema.locator("css=#author_select .ng-value-container input")).forEach(l -> l.press("Backspace"));
//        ema.fill("[placeholder='mm/dd/yyyy']", "08012022");
//        ema.locator("css=#author_select .ng-value-container input").fill("Cane, Daniel, MD");
//        ema.click("text=Cane, Daniel, MD");
//        sleep();
//        ema.fill("css=#patientSearchAutoComplete .ng-value-container div[role='combobox']>input", "Cheesyapp, WallyfVexd");
//        var searchOption = ema.locator("text=Cheesyapp, WallyfVexd");
//        searchOption.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
//        searchOption.click();
//        sleep();
//        ema.close();
//        browserOne.close();
//        playwright.close();

    }

    protected static void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
