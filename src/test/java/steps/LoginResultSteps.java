package steps;

import pages.LoginPage;
import pages.ProductsPage;

public class LoginResultSteps {
    ProductsPage productsPage = new ProductsPage();
    LoginPage loginPage = new LoginPage();
    public  LoginResultSteps verifyProductsPageUrl(){
        productsPage.checkProductsPageUrl();
        return this;
    }

    public LoginResultSteps verifyNotificationsForInvalidData(String message){
        loginPage.checkNotificationForInvalidData(message);
        return this;
    }
}
