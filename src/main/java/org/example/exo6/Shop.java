package org.example.exo6;

import org.example.exo5.NotImplementedException;

import java.util.Arrays;
import java.util.List;

public class Shop {


    private List<Product> products;
    int modifNegatif = 1;

    public void update(Product product) {
        product.setSellIn(product.getSellIn() - modifNegatif);

        if ("ProduitLaitier".equals(product.getType())) {
            modifNegatif = modifNegatif * 2;
        }

        if ("BrieVieilli".equals(product.getName())) {
            product.setQuality(product.getQuality() + 1);
        } else if (product.getSellIn() < 0) {
            if (product.getQuality() > 0) {
                product.setQuality(product.getQuality() - (2 * modifNegatif));
            }
        } else {

            if (product.getQuality() > 0) {
                product.setQuality(product.getQuality() - modifNegatif);
            }
        }


        if (product.getQuality() < 0) {
            product.setQuality(0);
        }

        if (product.getQuality() > 50) {
            product.setQuality(50);
        }
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
