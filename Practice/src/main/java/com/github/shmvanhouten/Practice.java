package com.github.shmvanhouten;

public class Practice {
    public String getPositionInAlphabet(char alphabet) {
        Character referenceChar = '`';
        int position = Math.abs(referenceChar.compareTo(alphabet));
        return "Position of alphabet: "+ position;
    }
}
