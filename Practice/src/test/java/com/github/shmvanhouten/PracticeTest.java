package com.github.shmvanhouten;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PracticeTest {
    @Test
    public void itShouldGiveThePositionOfTheCharacterInTheAlphabet() throws Exception{
        Practice test = new Practice();
        assertThat(test.getPositionInAlphabet('a'), is("Position of alphabet: 1"));
        System.out.println("hi" + 1 + 1);
    }
}
