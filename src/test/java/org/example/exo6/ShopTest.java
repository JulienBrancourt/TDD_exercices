package org.example.exo6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ShopTest {

    @Test
    public void testUpdateWhenSellIn_1_ThenQUality_1() {
        Product product = new Product();
        product.setSellIn(10);
        product.setQuality(20);
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);

        Assertions.assertEquals(9, product.getSellIn());
        Assertions.assertEquals(19, product.getQuality());
    }

    @Test
    public void testUpdateWhenSellInIs_0_ThenQUality_double() {
        Product product = new Product();
        product.setSellIn(0);
        product.setQuality(20);
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);

        Assertions.assertEquals(-1, product.getSellIn());
        Assertions.assertEquals(18, product.getQuality());
    }

    @Test
    public void testUpdateWhenQuality_0_ThenQUalityStay_0() {
        Product product = new Product();
        product.setSellIn(10);
        product.setQuality(0);
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);

        Assertions.assertEquals(9, product.getSellIn());
        Assertions.assertEquals(0, product.getQuality());
    }

    @Test
    public void testUpdateWhenQuality_50_ThenQUalityMax_50() {
        Product product = new Product();
        product.setSellIn(10);
        product.setQuality(60);
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);

        Assertions.assertEquals(9, product.getSellIn());
        Assertions.assertEquals(50, product.getQuality());
    }

    @Test
    public void testUpdateWhenBrieVieilliThenQUalityincrease_1() {
        Product product = new Product();
        product.setName("BrieVieilli");
        product.setSellIn(10);
        product.setQuality(20);
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);

        Assertions.assertEquals(9, product.getSellIn());
        Assertions.assertEquals(21, product.getQuality());
    }
    @Test
    public void testUpdateWhenProduitLaitierThenQUality_2() {
        Product product = new Product();
        product.setType("ProduitLaitier");
        product.setSellIn(10);
        product.setQuality(20);
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(product));

        shop.update(product);

        Assertions.assertEquals(9, product.getSellIn());
        Assertions.assertEquals(18, product.getQuality());
    }
}