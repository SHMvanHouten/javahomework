package com.github.shmvanhouten;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FactorialTest {

    @Test
    public void itShouldGiveTheFactorialOfTheInput() throws Exception {
        assertThat("3! == 6", Factorial.getFactorial(3), is(BigInteger.valueOf(6)));
        assertThat("5! == 120", Factorial.getFactorial(5), is(BigInteger.valueOf(120)));
        assertThat("9! == 362880", Factorial.getFactorial(9), is(new BigInteger("362880")));

        BigInteger fifteenFact = new BigInteger("1307674368000");
        assertThat("15! == 1307674368000", Factorial.getFactorial(15), is(fifteenFact));
        System.out.println(Factorial.getFactorial(25));
    }

    @Test
    public void itShouldChangeItToString() throws Exception {
        assertThat("9! == 362880", Factorial.getFactorialString(9), is("362880"));
        assertThat("15! == 1307674368000", Factorial.getFactorialString(15), is("1307674368000"));
    }

    @Test
    public void itShouldGetTheFactorialThroughALoop() throws Exception {
        assertThat("3! == 6", Factorial.Factorial(3), is("6"));
        assertThat("9! == 362880", Factorial.Factorial(9), is("362880"));
        assertThat("15! == 1307674368000", Factorial.Factorial(15), is("1307674368000"));
    }
}