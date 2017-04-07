package com.github.shmvanhouten;

import org.junit.Test;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.time.Month.JUNE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {
    @Test
    public void itShouldReturnAStringWithTheProductIdentifiers()throws Exception{
        Product product = new Product("bananas", of(2017,APRIL,13));
        assertThat(product.toString(), is("Product {name = 'bananas', expiryDate = 2017-04-13}"));
    }
}
