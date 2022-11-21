package steps;

import pages.ProductsPage;

public class ProductsSteps {
    ProductsPage productsPage = new ProductsPage();
    public ProductsResultSteps doSelectedOption( String optionText){
        productsPage.chooseTheSelectedOption(optionText);
        return new ProductsResultSteps();
    }
}
