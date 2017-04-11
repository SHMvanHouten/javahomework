package com.github.shmvanhouten;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PracticeTest2 {
    @Test
    public void itShouldTurnANonCapitalLetterIntoCapital() throws Exception{
        Practice2 practice = new Practice2();
        assertThat(practice.changeTheStringIntoTheOddStringThingy("a"), is("A"));
    }

    @Test
    public void itShouldTurnTheSecondLetterInTheStringToAnUpperCaseAndLowerCase() throws Exception{
        Practice2 practice = new Practice2();
        assertThat(practice.changeTheStringIntoTheOddStringThingy("ab"), is("A-Bb"));
        assertThat(practice.changeTheStringIntoTheOddStringThingy("abc"), is("A-Bb-Ccc"));
    }
}
