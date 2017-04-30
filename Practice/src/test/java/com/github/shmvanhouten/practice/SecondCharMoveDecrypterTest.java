package com.github.shmvanhouten.practice;

import com.github.shmvanhouten.practice.SecondCharMoveDecrypter;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SecondCharMoveDecrypterTest {

    @Test
    public void itShouldTakeEveryEvenLetterFromTheFirstHalfAndEverySecondLetterFromTheSecondHalf() throws Exception {
        assertThat(SecondCharMoveDecrypter.weaveTheSecondHalfWithFirst("hsi  etTi sats!"), is("This is a test!"));
        assertThat(SecondCharMoveDecrypter.weaveTheSecondHalfWithFirst("246813579"), is("123456789"));
    }

    @Test
    public void itShouldDoTheDecryptionNTimes() throws Exception {
        assertThat(SecondCharMoveDecrypter.decryptNTimes("s eT ashi tist!", 2), is("This is a test!"));
    }
}