package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.Utils;
import org.testng.Assert;

public class Dashboard {

    private final Page page;
    private final Utils utils;

    private final Locator dashboardTab;
    private final Locator employeeManagementTab;
    private final Locator btnEmployee;
    private final Locator btnSupervisor;
    private final Locator btnEmploymentClose;
    private final Locator myDashboard;
    private final Locator smartOfficeDashboard;
    private final Locator supervisorTab;
    private final Locator leaveOverview;

    public Dashboard(Page page) {
        this.page = page;
        this.utils = new Utils();

        dashboardTab = page.locator("//p[contains(text(),'Dashboard')]");
        employeeManagementTab = page.locator("//p[contains(text(),'Employee Management')]");
        btnEmployee = page.locator("//p[contains(text(),'Employees')]");
        btnSupervisor = page.locator("//p[contains(text(),'Supervisors')]");
        btnEmploymentClose = page.locator("//p[contains(text(),'Employment Close')]");
        myDashboard = page.locator("//span[contains(text(),'My-dashboard')]");
        smartOfficeDashboard = page.locator("text=Quick Links");
        supervisorTab = page.locator("#simple-tab-supervisor");
        leaveOverview = page.locator("text=Leave Overview");
    }

    public Dashboard(Page page, Utils utils, Locator dashboardTab, Locator employeeManagementTab, Locator btnEmployee, Locator btnSupervisor, Locator btnEmploymentClose, Locator myDashboard, Locator smartOfficeDashboard, Locator supervisorTab, Locator leaveOverview, Locator officialLetterTab, Locator btnLetterType) {
        this.page = page;
        this.utils = utils;
        this.dashboardTab = dashboardTab;
        this.employeeManagementTab = employeeManagementTab;
        this.btnEmployee = btnEmployee;
        this.btnSupervisor = btnSupervisor;
        this.btnEmploymentClose = btnEmploymentClose;
        this.myDashboard = myDashboard;
        this.smartOfficeDashboard = smartOfficeDashboard;
        this.supervisorTab = supervisorTab;
        this.leaveOverview = leaveOverview;
    }

    public void clickEmployeeManagementTab() throws InterruptedException {
        employeeManagementTab.click();
    }

    public void clickEmployeeBtn() {
        btnEmployee.waitFor();
        btnEmployee.click();
    }

    public void clickSupervisorBtn() {
        btnSupervisor.waitFor();
        btnSupervisor.click();
    }

    public void clickEmploymentCloseBtn() {
        btnEmploymentClose.waitFor();
        btnEmploymentClose.click();
    }

    public void assertEmployeeDashboard() {
        try {
            smartOfficeDashboard.waitFor(new Locator.WaitForOptions().setTimeout(10000));
            Assert.assertTrue(smartOfficeDashboard.isVisible(), "Quick Links is not visible on the dashboard.");
            System.out.println("Quick Links is visible and asserted successfully.");
        } catch (AssertionError e) {
            System.err.println("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception ex) {
            System.err.println("Unexpected exception while verifying 'Quick Links': " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void assertSupervisorDashboard() {
        try {
            leaveOverview.waitFor(new Locator.WaitForOptions().setTimeout(10000));
            Assert.assertTrue(leaveOverview.isVisible(), "'Leave Overview' content is not displayed on Supervisor Dashboard.");
            System.out.println("'Leave Overview' content is displayed successfully on Supervisor Dashboard.");
        } catch (AssertionError e) {
            System.err.println("Assertion failed in Supervisor Dashboard: " + e.getMessage());
            throw e;
        } catch (Exception ex) {
            System.err.println("Unexpected exception in Supervisor Dashboard assertion: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
