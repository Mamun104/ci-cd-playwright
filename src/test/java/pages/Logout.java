package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Logout {

    private final Page page;

    private final Locator userCornerAvatar;
    private final Locator btnLogout;

    public Logout(Page page) {
        this.page = page;
        this.userCornerAvatar = page.locator(".MuiAvatar-root").first();
        this.btnLogout = page.locator("//p[normalize-space()='Sign Out']");
    }

    public void clickLogout() throws InterruptedException {
        Thread.sleep(1000);
        userCornerAvatar.waitFor(new Locator.WaitForOptions().setTimeout(1000));
        userCornerAvatar.click();


        Thread.sleep(1000);
        btnLogout.waitFor(new Locator.WaitForOptions().setTimeout(1000));
        btnLogout.click();
    }
}
