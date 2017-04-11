package com.github.shmvanhouten;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.lang.reflect.Array;

public class Practice2 {
    public String changeTheStringIntoTheOddStringThingy(String inputString) {
        StringBuilder outputString =  new StringBuilder();
        char[] stringArray = inputString.toCharArray();
        outputString.append(Character.toUpperCase(stringArray[0]));
        for (int i = 1; i<stringArray.length; i++){
            char letter = stringArray[i];
            outputString.append('-');
            outputString.append(Character.toUpperCase(letter));
            letter = Character.toLowerCase(letter);
            for(int j=0; j<i; j++){
                outputString.append(letter);
            }
        }
        return outputString.toString();
    }
}
