package steps;

import pages.ProductsPage;
import pages.ShoppingCartPage;

public class ProductsResultSteps {
    ProductsPage productsPage = new ProductsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public ProductsResultSteps verifySelectingProducts(String methodOfSorting) {
        if (methodOfSorting.equals("SortingByNameAsc"))
            productsPage.checkProductsByNamesAsc();
        if (methodOfSorting.equals("SortingByNameDesc"))
            productsPage.checkProductsByNamesDesc();
        if (methodOfSorting.equals("SortingByPriceAsc"))
            productsPage.checkProductsByPricesAsc();
        if (methodOfSorting.equals("SortingByPriceDesc"))
            productsPage.checkProductsByPricesDesc();
        return this;
    }

    public ProductsResultSteps verifyTheAdditionOfProductsToTheCart(String ProductName) {
        shoppingCartPage.checkTheAdditionOfProductsToTheCart(ProductName);
        return this;
    }
}
