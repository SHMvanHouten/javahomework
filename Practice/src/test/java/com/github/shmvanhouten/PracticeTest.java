package com.github.shmvanhouten;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PracticeTest {
    @Test
    public void itShouldGiveThePositionOfTheCharacterInTheAlphabet() throws Exception{
        Practice test = new Practice();
        assertThat(test.getPositionInAlphabet('a'), is("Position of alphabet: 1"));
        System.out.println("hi" + 1 + 1);
        System.out.println((int)'t');
    }

    @Test
    public void itShouldRoundTheDoubleToTwoDecimalPoints() throws Exception{
        Practice test = new Practice();
        assertThat(test.roundToTwoDecimalPlaces(5.5589), is(5.56));
        assertThat(test.roundToTwoDecimalPlaces(3.3424), is(3.34));
        DecimalFormat decimalFormat =  new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(5.5589));
    }

    @Test
    public void itShouldTurnAnUpperCaseCharIntoALowerCase() throws Exception{
        Practice test = new Practice();
        assertThat(test.changeUpperCaseToLowerCase('A'), is('a'));
    }
    @Test
    public void itShouldTurnUpperCaseLettersToLowerCaseAndViceVersa() throws Exception{
        Practice test = new Practice();
        assertThat(test.changeAllLettersToOppositeCase("HeLlo"), is("hElLO"));
    }
}
