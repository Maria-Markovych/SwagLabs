package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ProductsPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'inventory_item_price']")
    List<WebElement> prices;
    @FindBy(xpath ="//div[@class = 'inventory_item_name']" )
    List<WebElement> productsName;



    public void checkProductsPageUrl(){
        String currentUrl =  driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "Invalid URL");
    }

    public void chooseTheSelectedOption(String optionText){
        Select select = new Select(driver.findElement(By.xpath("//select[@data-test = 'product_sort_container']")));
        select.selectByVisibleText(optionText);
    }
    public List<String> turnProductsNameToString(){
        List<String> products = new ArrayList<>();
        for(int i = 0; i < productsName.size(); i++){
            products.add(i, productsName.get(i).getText());
        }
        return products;
    }
    public List<Double> turnPricesToDouble(){
        List<Double> price = new ArrayList<>();
        for(int i = 0; i < prices.size(); i++){
            price.add(i, Double.parseDouble(prices.get(i).getText().split("\\$")[1]));
        }
        return price;
    }
    public List<String> productsNameSorting(){
        List<String> productsSorting = new ArrayList<>(turnProductsNameToString());
        Collections.sort(productsSorting);
        return productsSorting;
    }

    public List<Double> pricesSorting(){
        List<Double> pricesSorting = new ArrayList<>(turnPricesToDouble());
        Collections.sort(pricesSorting);
        return pricesSorting;
    }

    public void checkSortingProductsReverse(){
        List<String> productsSortingReverse = new ArrayList<>(productsNameSorting());
       Collections.reverse(productsSortingReverse);
       boolean equals = productsSortingReverse.equals(turnProductsNameToString());
        assertTrue(equals,"No products sorted by name");
    }
    public void checkSortingProducts(){
        boolean equals = productsNameSorting().equals(turnProductsNameToString());
        assertTrue(equals,"No products sorted by name");
    }

    public void checkSortingPrices(){
        boolean equals = pricesSorting().equals(turnPricesToDouble());
        assertTrue(equals,"No products sorted by price");
    }
    public void checkSortingPricesReverse(){
        List<Double> pricesSortingReverse = new ArrayList<>(pricesSorting());
        Collections.reverse(pricesSortingReverse);
        boolean equals = pricesSortingReverse.equals(turnPricesToDouble());
        assertTrue(equals, "No products sorted by price");
    }
}
