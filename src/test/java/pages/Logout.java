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
        userCornerAvatar.click();
        btnLogout.click();
    }
}
