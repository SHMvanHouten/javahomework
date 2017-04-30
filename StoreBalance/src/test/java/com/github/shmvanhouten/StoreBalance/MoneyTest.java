package com.github.shmvanhouten.StoreBalance;

import com.github.shmvanhouten.StoreBalance.Money;
import org.junit.Test;


import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class MoneyTest {

    @Test
    public void itShouldAcceptADecimalNumberAndACurrency() throws Exception{
        Money tomatoSoupPrice = new Money("3.23" , "eur");
        assertThat(tomatoSoupPrice.getAmount(), is(new BigDecimal("3.23")));
    }

    @Test
    public void itShouldAddTwoMoneyAmountsTogether() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", "eur");
        Money colaPrice = new Money("1.75", "eur");
        assertThat(tomatoSoupPrice.add(colaPrice), is(new Money("4.98", "eur")));
    }

    @Test
    public void itShouldMultiplyAMoneyObjectTogether() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", "eur");
        assertThat(tomatoSoupPrice.multiply(10), is(new Money("32.30", "eur")));
    }

    @Test
    public void itShouldSubtractOneMoneyAmountFromAnother() throws Exception{
        Money valueOfThreeCansOfTomatoSoup = new Money("3.23", "eur").multiply(3);
        Money valueOfOneCanOfTomatoSoup = new Money("3.23", "eur");
        assertThat(valueOfThreeCansOfTomatoSoup.minus(valueOfOneCanOfTomatoSoup),is(new Money("6.46", "eur")));
    }

    @Test (expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionWhenTwoDifferentCurrenciesAreEntered() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", "dol");
        Money colaPrice = new Money("1.75", "eur");
        tomatoSoupPrice.add(colaPrice);
    }

    @Test (expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionOnNegativeCurrencyInput() throws Exception {
        Money negativePrice = new Money("-2.50", "eur");
    }
}
