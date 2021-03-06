package com.github.shmvanhouten.StoreBalance;

import com.github.shmvanhouten.StoreBalance.Product;
import org.junit.Test;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {
    @Test
    public void itShouldReturnAStringWithTheProductIdentifiers()throws Exception{
        Product product = new Product("bananas", of(2017,APRIL,13));
        assertThat(product.toString(), is("Product {name = 'bananas', expiryDate = 2017-04-13}"));
        System.out.println(product);
    }
}
