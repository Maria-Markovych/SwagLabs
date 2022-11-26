package tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.*;

import static tests.Config.BASE_PATH;
import static tests.Config.USERNAME;

public class ProductsTest extends BaseTest {
    @BeforeClass
    public void beforeClass() {
        getDriver().navigate().to(BASE_PATH);
        loginSteps.doLogin(USERNAME, "secret_sauce");
    }

    @AfterGroups(groups = "addProductsToCart")
    public void afterGroups() {
        getDriver().navigate().to(BASE_PATH + "inventory.html");
    }

    @Test(dataProvider = "dataProviderOptionText", dataProviderClass = StaticDataProvider.class)
    public void testSortingAfterChooseFilter(String selectText, String methodOfSorting) {
        productsSteps.doSelectedOption(selectText).verifySelectingProducts(methodOfSorting);
    }

    @Test(dataProvider = "dataProviderIdButtonAddToCart", dataProviderClass = StaticDataProvider.class,
            expectedExceptions = StaleElementReferenceException.class, groups = "addProductsToCart", priority = 1)
    public void testClickButtonAddToCart(String idButtonAdd) {
        productsSteps.addProductsToCart(idButtonAdd);
    }

    @Test(dataProvider = "dataProviderIdButtonRemove", dataProviderClass = StaticDataProvider.class,
            expectedExceptions = StaleElementReferenceException.class, priority = 3)
    public void testClickButtonRemove(String idButtonRemove) {
        productsSteps.removeProductsFromCart(idButtonRemove);
    }

    @Test(dataProvider = "dataProviderAddProductsToCart", dataProviderClass = StaticDataProvider.class,
            groups = "addProductsToCart", priority = 2)
    public void testAdditionOfProductsToTheCart(String ProductsName) {
        productsSteps.openShoppingCart().verifyTheAdditionOfProductsToTheCart(ProductsName);
    }
}