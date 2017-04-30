package com.github.shmvanhouten.practice;

import com.github.shmvanhouten.practice.EqualSidesOfAnArray;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class EqualSidesOfAnArrayTest {
    @Test
    public void itShouldGetTheIndexWhereBothSidesOfTheIndexAddUptoTheSameAmount() throws Exception {
        EqualSidesOfAnArray test = new EqualSidesOfAnArray();
        int[] inputArray = {1, 2, 3, 4, 3, 2, 1};
        int[] inputArray2 = {1,2,3,4,5,6};
        int[] inputArray3 = {20,10,30,10,10,15,35};
        assertThat(test.getIndexWhereBothSidesOfTheIndexAddUpToTheSameAmount(inputArray), is(3));
        assertThat(test.getIndexWhereBothSidesOfTheIndexAddUpToTheSameAmount(inputArray2), is(-1));
        assertThat(test.getIndexWhereBothSidesOfTheIndexAddUpToTheSameAmount(inputArray3), is(3));
    }
}