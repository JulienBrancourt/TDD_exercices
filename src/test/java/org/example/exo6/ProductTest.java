package org.example.exo6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductTest {
    private Product product;
    private Shop shop;

    @Test
    public void testProduct() {
        Product product = new Product();
         product.setSellIn(10);
        product.setQuality(20);

        // Créer une instance de Shop et ajouter le produit à la liste
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);


        Assertions.assertEquals(9, product.getSellIn());
        Assertions.assertEquals(19, product.getQuality());

    }
}
