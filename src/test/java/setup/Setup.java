package setup;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Login;
import utils.Utils;

public class Setup {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    @BeforeSuite
    public void setup() throws Exception {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(1920, 1080)
        );
        page = context.newPage();
        page.navigate(Utils.getBaseUrl());
        Login login = new Login(page);
        login.doLogin(1);
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils(page);
                util.takeScreenShot(result.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite
    public void quitBrowser() {
        try {
            if (context != null) context.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
