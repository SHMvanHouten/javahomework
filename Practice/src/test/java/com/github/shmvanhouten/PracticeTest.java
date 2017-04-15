package com.github.shmvanhouten;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

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
    @Test
    public void itShouldSayIfANumberIsASquareOrNot() throws Exception{
        assertThat(Practice.isSquare(26), is(false));
    }

    @Test
    public void itShouldTurnTheFirstLetterOfEachWordIntoACapitalLetter() throws Exception {
        Practice practice = new Practice();
        String example = "How can mirrors be real if our eyes aren't real";
        String testString = "How Can Mirrors Be Real If Our Eyes Aren't Real";
        assertThat(practice.changeFirstLetterOfEachWordToUpperCase(example), is(testString));
    }

    @Test
    public void itShouldSwap8BitNumberArray() throws Exception {
        Practice practice = new Practice();
        int[] inputArray = new int[]{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        int[] outPutArray = new int[]{1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        assertThat(practice.reverse8BitArray(inputArray), is(outPutArray));
        int[] inputArray2 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        int[] testArray2 = new int[]{17,18,19,20,21,22,23,24,9,10,11,12,13,14,15,16,1,2,3,4,5,6,7,8};
        assertThat(practice.reverse8BitArray(inputArray2), is(testArray2));
    }

    @Test
    public void itShouldTurnTheIntArrayIntoAPhoneNumberString() throws Exception {
        Practice practice = new Practice();
        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        assertThat(practice.getPhoneNumber(inputArray),is("(123) 456-7890"));
    }

    @Test
    public void spinWordsOver4LettersLong() throws Exception {
        String sentence = "Stop spinning my words";
        assertThat(Practice.spinWordsOver4LettersLong(sentence), is("Stop gninnips my sdrow"));
    }

    @Test
    public void countTheNumberOfOnesInTheBinaryRepresentationOfInteger() throws Exception {
        assertThat(Practice.getAmountOfOnesInBinaryRepresentation(1234), is(5));
        assertThat(Practice.getAmountOfOnesInBinaryRepresentation(4), is(1));
        assertThat(Practice.getAmountOfOnesInBinaryRepresentation(7), is(3));
        System.out.println(Integer.bitCount(1234));
    }

    @Test
    public void itShouldPutTheWordsInOrderOfTheNumberInThem() throws Exception {
        String testSentence = "Fo1r the2 g3ood 4of th5e pe6ople";
        String inputSentence = "4of Fo1r pe6ople g3ood th5e the2";
        assertThat(Practice.orderWordsAccordingToNumber("is2 Thi1s T4est 3a"),is("Thi1s is2 3a T4est"));
        assertThat(Practice.orderWordsAccordingToNumber(inputSentence),is(testSentence));
        assertThat(Practice.orderWordsAccordingToNumber(""),is(""));
    }

    @Test
    public void itShouldReturnAAAAForTTTT() throws Exception {
        String inputSentence = "TTTT";
        String testSentence = "AAAA";
        assertThat(Practice.getComplementBase(inputSentence),is(testSentence));
    }

    @Test
    public void itShouldReturnCATAForGTAT() throws Exception {
        String inputSentence = "GTAT";
        String testSentence = "CATA";
        assertThat(Practice.getComplementBase(inputSentence),is(testSentence));
    }
}
