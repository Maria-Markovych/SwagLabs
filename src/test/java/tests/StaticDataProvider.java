package tests;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "dataProviderInvalidLogins")
    public static Object[][] createInvalidData() {
        return new Object[][]{
                {"", "cbja", "Epic sadface: Username is required"},
                {"374tfrvd", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username and password are required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"nbsdadtt23", "jbcj", "Epic sadface: Username and password do not match any user in this service"}};
    }

    @DataProvider(name = "dataProviderValidLogins")
    public static Object[][] createValidData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}};
    }

    @DataProvider(name = "dataProviderOptionText")
    public static Object[][] createOptionText() {
        return new Object[][]{
                {"Name (A to Z)", "SortingByName"},
                {"Name (Z to A)", "SortingByNameReverse"},
                {"Price (low to high)", "SortingByPrice"},
                {"Price (high to low)", "SortingByPriceReverse"}};
    }

    @DataProvider(name = "dataProviderIdButtonAddToCart")
    public static Object[][] createIdButtonAddToCart() {
        return new Object[][]{
                {"add-to-cart-sauce-labs-backpack"},
                {"add-to-cart-sauce-labs-bike-light"},
                {"add-to-cart-sauce-labs-bolt-t-shirt"},
                {"add-to-cart-sauce-labs-fleece-jacket"},
                {"add-to-cart-sauce-labs-onesie"},
                {"add-to-cart-test.allthethings()-t-shirt-(red)"}};
    }

    @DataProvider(name = "dataProviderIdButtonRemove")
    public static Object[][] createIdButtonRemove() {
        return new Object[][]{
                {"remove-sauce-labs-backpack"},
                {"remove-sauce-labs-bike-light"},
                {"remove-sauce-labs-bolt-t-shirt"},
                {"remove-sauce-labs-fleece-jacket"},
                {"remove-sauce-labs-onesie"},
                {"remove-test.allthethings()-t-shirt-(red)"}};
    }

    @DataProvider(name = "dataProviderAddProductsToCart")
    public static Object[][] createProductsName() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce L"},
                {"Test.allTheThings() T-Shirt (Red)"}};
    }
}
