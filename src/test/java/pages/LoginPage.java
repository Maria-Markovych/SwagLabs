package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    WebElement userField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    WebElement notification;

    public void fillUseField(String username) {
        userField.clear();
        userField.sendKeys(username);
    }

    public void fillPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void checkNotificationForInvalidData(String message) {
        assertEquals(notification.getText(), message, "Invalid message");
    }
}
