package com.github.shmvanhouten;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.lang.reflect.Array;
import java.util.List;

public class Practice2 {

    public int getDecimalValue(List<Integer> binary) {
        int decimalValue = 0;
        int binaryLength = binary.size();
        int valueOfBinaryDigitInDecimal = 1;
        System.out.println(Math.pow(binary.get(0), binaryLength));
        for(int i = binaryLength - 1; i >= 0; i--){
            decimalValue += (valueOfBinaryDigitInDecimal) * binary.get(i);
            valueOfBinaryDigitInDecimal *= 2;
        }
        return decimalValue;
    }
}
