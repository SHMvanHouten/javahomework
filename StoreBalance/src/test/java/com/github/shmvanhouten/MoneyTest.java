package com.github.shmvanhouten;

import org.junit.Test;


import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class MoneyTest {
    @Test
    public void itShouldAcceptADecimalNumberAndACurrency() throws Exception{
        Money tomatoSoupPrice = new Money("3.23" , "eur");
        Money colaPrice = new Money("1.75", "eur");
        assertThat(tomatoSoupPrice.getAmount(), is(new BigDecimal("3.23")));
        BigDecimal mfmf = new BigDecimal("32");
        System.out.println(mfmf.doubleValue());
    }

    @Test
    public void itShouldAddTwoMoneyAmountsTogether() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", "eur");
        Money colaPrice = new Money("1.75", "eur");
        assertThat(tomatoSoupPrice.add(colaPrice), is(new Money("4.98", "eur")));
    }
}
