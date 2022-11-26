package steps;

import pages.ProductsPage;

public class ProductsSteps {
    ProductsPage productsPage = new ProductsPage();

    public ProductsResultSteps doSelectedOption(String optionText) {
        productsPage.chooseTheSelectedOption(optionText);
        return new ProductsResultSteps();
    }

    public ProductsResultSteps addProductsToCart(String idButtonAddToCart) {
        productsPage.clickButtonAddToCart(idButtonAddToCart);
        return new ProductsResultSteps();
    }

    public ProductsResultSteps removeProductsFromCart(String idButtonRemove) {
        productsPage.clickButtonRemove(idButtonRemove);
        return new ProductsResultSteps();
    }

    public ProductsResultSteps openShoppingCart() {
        productsPage.clickShoppingCart();
        return new ProductsResultSteps();
    }
}
