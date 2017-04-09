package com.github.shmvanhouten;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;
    private String currency;
    Money(double amountInput, String currencyInput){
        amount = new BigDecimal(amountInput);
        currency = currencyInput;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money add(Money amountToAdd) {
        return new Money(amount.add(amountToAdd.getAmount()).doubleValue(), currency);
    }

    @Override
    public String toString() {
        return
    }
}
