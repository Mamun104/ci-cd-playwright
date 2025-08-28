package pages;

import com.microsoft.playwright.Page;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class Login {

    private final Page page;

    private final String usernameInput = "input[name='username']";
    private final String passwordInput = "input[type='password']";
    private final String submitButton =  "button[type='submit']";

    public Login(Page page) {
        this.page = page;
    }

    public void doLogin(int userIndex) throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        List<?> data = Utils.readJSONArray("./src/test/resources/Users.json");
        JSONObject userObj = (JSONObject) data.get(userIndex);
        String userName = (String) userObj.get("userName");
        String passwd = (String) userObj.get("password");


        page.fill(usernameInput, "");
        page.fill(usernameInput, userName);
        page.fill(passwordInput, "");
        page.fill(passwordInput, passwd);
        page.click(submitButton);
    }
}
