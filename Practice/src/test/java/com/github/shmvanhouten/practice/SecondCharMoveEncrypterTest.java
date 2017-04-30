package com.github.shmvanhouten.practice;

import com.github.shmvanhouten.practice.SecondCharMoveEncrypter;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SecondCharMoveEncrypterTest {

    @Test
    public void itShouldTakeEverySecondCharacterAndAppendItToANewStringAndThenAppendTheRemainingCharacters() throws Exception {
        assertThat(SecondCharMoveEncrypter.moveEverySecondCharToTheFront("This is a test!"), is("hsi  etTi sats!"));
    }

    @Test
    public void itShouldDoTheEncryptionNTimes() throws Exception {
        assertThat(SecondCharMoveEncrypter.encryptNTimes(2, "This is a test!"), is("s eT ashi tist!"));
        System.out.println(SecondCharMoveEncrypter.moveEverySecondCharToTheFront("123456789"));
    }
}