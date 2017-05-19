package com.github.shmvanhouten.StoreBalance;

import com.github.shmvanhouten.StoreBalance.Money;
import org.junit.Test;


import java.math.BigDecimal;

import static com.github.shmvanhouten.StoreBalance.Currency.EUR;
import static com.github.shmvanhouten.StoreBalance.Currency.USD;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class MoneyTest {

    @Test
    public void itShouldAcceptADecimalNumberAndACurrency() throws Exception{
        Money tomatoSoupPrice = new Money("3.23" , EUR);
        assertThat(tomatoSoupPrice.getAmount(), is(new BigDecimal("3.23")));
    }

    @Test
    public void itShouldAddTwoMoneyAmountsTogether() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", EUR);
        Money colaPrice = new Money("1.75", EUR);
        assertThat(tomatoSoupPrice.add(colaPrice), is(new Money("4.98", EUR)));
    }

    @Test
    public void itShouldMultiplyAMoneyObjectTogether() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", EUR);
        assertThat(tomatoSoupPrice.multiply(10), is(new Money("32.30", EUR)));
    }

    @Test
    public void itShouldSubtractOneMoneyAmountFromAnother() throws Exception{
        Money valueOfThreeCansOfTomatoSoup = new Money("3.23", EUR).multiply(3);
        Money valueOfOneCanOfTomatoSoup = new Money("3.23", EUR);
        assertThat(valueOfThreeCansOfTomatoSoup.minus(valueOfOneCanOfTomatoSoup),is(new Money("6.46", EUR)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionWhenTwoDifferentCurrenciesAreEntered() throws Exception{
        Money tomatoSoupPrice = new Money("3.23", USD);
        Money colaPrice = new Money("1.75", EUR);
        tomatoSoupPrice.add(colaPrice);
    }

    @Test (expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionOnNegativeCurrencyInput() throws Exception {
        Money negativePrice = new Money("-2.50", EUR);
    }
}
