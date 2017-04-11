package com.github.shmvanhouten;

import org.junit.Test;

import java.lang.reflect.Array;
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
}
