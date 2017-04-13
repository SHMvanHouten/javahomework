package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SecondCharMoveDecrypterTest {

    @Test
    public void itShouldTakeEveryEvenLetterFromTheFirstHalfAndEverySecondLetterFromTheSecondHalf() throws Exception {
        assertThat(SecondCharMoveDecrypter.weaveTheSecondHalfWithFirst("hsi  etTi sats!"), is("This is a test!"));
        assertThat(SecondCharMoveDecrypter.weaveTheSecondHalfWithFirst("246813579"), is("123456789"));
    }
}