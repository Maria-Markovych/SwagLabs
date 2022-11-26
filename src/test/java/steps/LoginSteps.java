package steps;

import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    public LoginResultSteps doLogin(String username, String password) {
        loginPage.fillUseField(username);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        return new LoginResultSteps();
    }
}
