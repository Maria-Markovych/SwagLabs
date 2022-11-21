package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.LoginResultSteps;
import static tests.Config.LOGIN_PAGE;

public class LoginTest extends BaseTest{

    @BeforeMethod
    public void beforeMethod(){

        getDriver().navigate().to(LOGIN_PAGE);
    }
    @Test(dataProvider = "dataProviderValidLogins")
    public void testValidLogins(String username, String password){
        loginSteps.doLogin(username,password).verifyProductsPageUrl();
    }
    @Test(dataProvider = "dataProviderInvalidLogins")
    public void testInvalidLogins(String username, String password, String notification){
       LoginResultSteps loginResultSteps =  loginSteps.doLogin(username,password);
       loginResultSteps.verifyNotificationsForInvalidData(notification);
    }

    @DataProvider(name = "dataProviderInvalidLogins")
    public static Object[][] createInvalidData() {
        return new Object[][]{
                {"", "cbja", "Epic sadface: Username is required"},
                {"374tfrvd", "", "Epic sadface: Password is required"},
                {"","", "Epic sadface: Username and password are required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"nbsdadtt23","jbcj", "Epic sadface: Username and password do not match any user in this service"}};
    }

    @DataProvider(name = "dataProviderValidLogins")
    public static Object[][] createValidData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user","secret_sauce"}};
    }
}
