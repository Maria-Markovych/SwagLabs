package steps;

import pages.ProductsPage;

public class ProductsResultSteps {
    ProductsPage productsPage = new ProductsPage();

    public ProductsResultSteps  verifySelectingProducts(String methodOfSorting){
        if(methodOfSorting.equals("SortingByName"))
            productsPage.checkSortingProducts();
        if(methodOfSorting.equals("SortingByNameReverse"))
            productsPage.checkSortingProductsReverse();
        if(methodOfSorting.equals("SortingByPrice"))
            productsPage.checkSortingPrices();
        if(methodOfSorting.equals("SortingByPriceReverse"))
            productsPage.checkSortingPricesReverse();
        return this;
    }

}
