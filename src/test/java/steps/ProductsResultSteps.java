package steps;

import pages.ProductsPage;
import pages.ShoppingCartPage;

public class ProductsResultSteps {
    ProductsPage productsPage = new ProductsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public ProductsResultSteps verifySelectingProducts(String methodOfSorting) {
        if (methodOfSorting.equals("SortingByName"))
            productsPage.checkSortingProductsByName();
        if (methodOfSorting.equals("SortingByNameReverse"))
            productsPage.checkSortingProductsByNameReverse();
        if (methodOfSorting.equals("SortingByPrice"))
            productsPage.checkSortingProductsByPrice();
        if (methodOfSorting.equals("SortingByPriceReverse"))
            productsPage.checkSortingProductsByPriceReverse();
        return this;
    }

    public ProductsResultSteps verifyTheAdditionOfProductsToTheCart(String ProductName) {
        shoppingCartPage.checkTheAdditionOfProductsToTheCart(ProductName);
        return this;
    }
}
