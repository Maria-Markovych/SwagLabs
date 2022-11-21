package tests;

import lombok.SneakyThrows;
import org.testng.annotations.*;

import static tests.Config.LOGIN_PAGE;
import static tests.Config.USERNAME;

public class ProductsTest extends BaseTest{
    @BeforeClass
    public void beforeClass(){
        getDriver().navigate().to(LOGIN_PAGE);
        loginSteps.doLogin(USERNAME,"secret_sauce");
    }

    @Test(dataProvider = "dataProviderOptionText")
    public void testSortingAfterChooseFilter(String selectText,String methodOfSorting){
        productsSteps.doSelectedOption(selectText).verifySelectingProducts(methodOfSorting);
    }
    @DataProvider(name = "dataProviderOptionText")
    public static Object[][] createOptionText() {
        return new Object[][]{
                {"Name (A to Z)","SortingByName"},
                {"Name (Z to A)","SortingByNameReverse"},
                {"Price (low to high)","SortingByPrice"},
                {"Price (high to low)","SortingByPriceReverse"}};
    }
}