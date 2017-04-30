package com.github.shmvanhouten.practice;

import com.github.shmvanhouten.practice.Practice2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PracticeTest2 {
    @Test
    public void itShouldReturnTheValue0for0and1for1() throws Exception{
        Practice2 practice2 = new Practice2();
        List<Integer> binary = new ArrayList<>(Arrays.asList(0));

        assertThat(practice2.getDecimalValue(binary), is(0));
        binary.clear();
        binary.add(1);
        assertThat(practice2.getDecimalValue(binary), is(1));
    }
    @Test
    public void itShouldReturnTheValues2And3For10and11BinaryToDecimal() throws Exception{
        Practice2 practice2 = new Practice2();
        List<Integer> binary = new ArrayList<>(Arrays.asList(1,0));
        List<Integer> binary2 = new ArrayList<>(Arrays.asList(1,1));
        assertThat(practice2.getDecimalValue(binary), is(2));
        assertThat(practice2.getDecimalValue(binary2), is(3));
        List<Integer> binary3 = new ArrayList<>(Arrays.asList(0,0,1,0));
        List<Integer> binary4 = new ArrayList<>(Arrays.asList(1,0,1,1));
        assertThat(practice2.getDecimalValue(binary3), is(2));
        assertThat(practice2.getDecimalValue(binary4), is(11));

    }
}
