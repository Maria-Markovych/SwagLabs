package steps;

import pages.ProductsPage;

public class ProductsSteps {
    ProductsPage productsPage = new ProductsPage();
    public ProductsResultSteps doSelectedOption( String optionText){
        productsPage.chooseTheSelectedOption(optionText);
        return new ProductsResultSteps();
    }
    public ProductsResultSteps doAddProduct(String idButtonAddProduct){
        productsPage.clickButtonAddToCart(idButtonAddProduct);
        return new ProductsResultSteps();
    }
    public ProductsResultSteps doRemoveProduct(String idButtonRemove){
        productsPage.clickButtonRemove(idButtonRemove);
        return new ProductsResultSteps();
    }
}
