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

    @Test(dataProvider = "dataProviderOptionText",dataProviderClass = StaticDataProvider.class)
    public void testSortingAfterChooseFilter(String selectText,String methodOfSorting){
        productsSteps.doSelectedOption(selectText).verifySelectingProducts(methodOfSorting);
    }

    @Test(dataProvider = "dataProviderIdButtonAddProduct",dataProviderClass = StaticDataProvider.class)
    public void testClickButtonAddToCart(String idButtonAdd){
        productsSteps.doAddProduct(idButtonAdd);
    }

    @Test(dataProvider ="dataProviderIdButtonRemove", dataProviderClass = StaticDataProvider.class)
    public void testClickButtonRemove(String idButtonRemove){
        productsSteps.doRemoveProduct(idButtonRemove);
    }

}