package com.github.shmvanhouten;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;
    private String currency;
    Money(String amountInput, String currencyInput){
        amount = new BigDecimal(amountInput);
        currency = currencyInput;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money add(Money amountToAdd) {
        BigDecimal returnValue = amount.add(amountToAdd.getAmount());
        return new Money(returnValue.toString(), currency);
    }

    public Money minus(Money amountToSubtract) {

        return new Money(amount.subtract(amountToSubtract.getAmount()).toString(), currency);
    }

    public Money multiply(Integer numberToMultiplyWith) {
        BigDecimal returnValue = amount.multiply(new BigDecimal(numberToMultiplyWith));
        return new Money(returnValue.toString(), currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != null ? !amount.equals(money.amount) : money.amount != null) return false;
        return currency != null ? currency.equals(money.currency) : money.currency == null;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount.toString().concat(" ").concat(currency);
    }


    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }


}
