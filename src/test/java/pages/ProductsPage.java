package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;
import static tests.Config.BASE_PATH;


public class ProductsPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'inventory_item_price']")
    List<WebElement> productsPrice;
    @FindBy(xpath = "//div[@class = 'inventory_item_name']")
    List<WebElement> productsName;
    @FindBy(xpath = "//div[@class='pricebar']/button")
    List<WebElement> btnAddOrRemoveToCart;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;
    @FindBy(className = "shopping_cart_badge")
    WebElement shoppingCartBage;

    public void checkProductsPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, BASE_PATH + "inventory.html", "Invalid URL");
    }

    public void chooseTheSelectedOption(String optionText) {
        Select select = new Select(driver.findElement(By.xpath("//select[@data-test = 'product_sort_container']")));
        select.selectByVisibleText(optionText);
    }

    public List<String> turnProductsNameToString() {
        List<String> products = new ArrayList<>();
        for (int i = 0; i < productsName.size(); i++) {
            products.add(i, productsName.get(i).getText());
        }
        return products;
    }

    public List<Double> turnProductsPriceToDouble() {
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < productsPrice.size(); i++) {
            prices.add(i, Double.parseDouble(productsPrice.get(i).getText().split("\\$")[1]));
        }
        return prices;
    }

    public List<String> productsByNameSorting() {
        List<String> productsNameSorting = new ArrayList<>(turnProductsNameToString());
        Collections.sort(productsNameSorting);
        return productsNameSorting;
    }

    public List<Double> productsByPriceSorting() {
        List<Double> productsPriceSorting = new ArrayList<>(turnProductsPriceToDouble());
        Collections.sort(productsPriceSorting);
        return productsPriceSorting;
    }

    public void checkSortingProductsByNameReverse() {
        List<String> productsByNameSortingReverse = new ArrayList<>(productsByNameSorting());
        Collections.reverse(productsByNameSortingReverse);
        boolean equals = productsByNameSortingReverse.equals(turnProductsNameToString());
        assertTrue(equals, "No products sorted by name");
    }

    public void checkSortingProductsByName() {
        boolean equals = productsByNameSorting().equals(turnProductsNameToString());
        assertTrue(equals, "No products sorted by name");
    }

    public void checkSortingProductsByPrice() {
        boolean equals = productsByPriceSorting().equals(turnProductsPriceToDouble());
        assertTrue(equals, "No products sorted by price");
    }

    public void checkSortingProductsByPriceReverse() {
        List<Double> productsByPriceSortingReverse = new ArrayList<>(productsByPriceSorting());
        Collections.reverse(productsByPriceSortingReverse);
        boolean equals = productsByPriceSortingReverse.equals(turnProductsPriceToDouble());
        assertTrue(equals, "No products sorted by price");
    }

    public void clickButtonAddToCart(String idButtonAddToCart) {
        for (WebElement buttonAddCart : btnAddOrRemoveToCart) {
            if (buttonAddCart.getAttribute("id").equals(idButtonAddToCart)) {
                buttonAddCart.click();
                assertFalse(buttonAddCart.getAttribute("id").equals(idButtonAddToCart),
                        "Button 'Add product' is not pressed");
                break;
            }
        }
    }

    public void clickButtonRemove(String idButtonRemove) {
        boolean idButtonRemoveExist = false;
        for (WebElement buttonRemove : btnAddOrRemoveToCart) {
            if (buttonRemove.getAttribute("id").equals(idButtonRemove)) {
                buttonRemove.click();
                idButtonRemoveExist = true;
                assertFalse(buttonRemove.getAttribute("id").equals(idButtonRemove),
                        "Button 'Remove' is not pressed");
            }
        }
        if (!idButtonRemoveExist) fail("No button was initially switched to remove");
    }

    public void clickShoppingCart() {
        waitElementIsVisible(shoppingCartBage);
        shoppingCart.click();
    }
}
