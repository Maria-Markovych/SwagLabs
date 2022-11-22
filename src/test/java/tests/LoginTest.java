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
    @Test(dataProvider = "dataProviderValidLogins", dataProviderClass = StaticDataProvider.class)
    public void testValidLogins(String username, String password){
        loginSteps.doLogin(username,password).verifyProductsPageUrl();
    }
    @Test(dataProvider = "dataProviderInvalidLogins",dataProviderClass = StaticDataProvider.class)
    public void testInvalidLogins(String username, String password, String notification){
       LoginResultSteps loginResultSteps =  loginSteps.doLogin(username,password);
       loginResultSteps.verifyNotificationsForInvalidData(notification);
    }
}
