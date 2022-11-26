package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginResultSteps;

import static tests.Config.BASE_PATH;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        getDriver().navigate().to(BASE_PATH);
    }

    @Test(dataProvider = "dataProviderValidLogins", dataProviderClass = StaticDataProvider.class)
    public void testValidLogins(String username, String password) {
        loginSteps.doLogin(username, password).verifyProductsPageUrl();
    }

    @Test(dataProvider = "dataProviderInvalidLogins", dataProviderClass = StaticDataProvider.class)
    public void testInvalidLogins(String username, String password, String notification) {
        loginSteps.doLogin(username, password).verifyNotificationsForInvalidData(notification);
    }
}
