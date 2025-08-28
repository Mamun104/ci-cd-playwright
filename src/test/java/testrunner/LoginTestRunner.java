package testrunner;

import org.testng.annotations.Test;
import pages.Dashboard;
import pages.Login;
import setup.Setup;
import utils.Utils;

public class LoginTestRunner extends Setup {

    private Login login;
    private Dashboard dashboard;

    @Test(priority = 0, description = "User can login with valid credentials")
    public void doLogin() throws Exception {

        login = new Login(page);
        dashboard = new Dashboard(page);

        dashboard.assertEmployeeDashboard();

        Utils.switchUser(page, 2);
        dashboard.assertSupervisorDashboard();

        Utils.switchUser(page, 1);
    }
}
