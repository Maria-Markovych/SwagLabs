package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> productsName;

    public void checkTheAdditionOfProductsToTheCart(String ProductName) {
        boolean productNameExist = productsName.stream().anyMatch(e -> e.getText().contains(ProductName));
        assertTrue(productNameExist, "Product was not added to the cart");
    }
}
