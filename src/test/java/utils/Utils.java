package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Utils {

    private final Page page;

    public Utils(Page page) {
        this.page = page;
    }

    public static List<?> readJSONArray(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {
            return (JSONArray) parser.parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base_url_v2");
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

    public void takeScreenShot(String name) {
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + name + "_" + time + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(fileWithPath)));
    }

    public void waitForElement(String selector, int timeoutInSeconds) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(timeoutInSeconds * 1000L));
    }

    public void scrollInto(String selector) {
        Locator element = page.locator(selector);
        element.scrollIntoViewIfNeeded();
    }

    public void assertAlertMessage(String selector, String expectedMessage) {
        waitForElement(selector, 5);
        String actualMessage = page.locator(selector).innerText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public static void switchUser(Page page, int userIndex) throws Exception {
        pages.Logout logout = new pages.Logout(page);
        pages.Login login = new pages.Login(page);

        try {
            logout.clickLogout();
        } catch (Exception ignored) {}

        login.doLogin(userIndex);
    }
}

