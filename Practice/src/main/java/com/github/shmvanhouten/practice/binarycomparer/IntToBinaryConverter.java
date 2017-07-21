package com.github.shmvanhouten.practice.binarycomparer;

import java.util.ArrayList;
import java.util.List;

public class IntToBinaryConverter {
    public List<Integer> convertIntegerToBinary(int integerToConvert) {
        String binaryString = Integer.toBinaryString(integerToConvert);
        List<Integer> eightBitBinary = new ArrayList<>();
        for (int i = 0; i < 8 - binaryString.length(); i++) {
            eightBitBinary.add(0);
        }
        for (char character : binaryString.toCharArray()) {
            eightBitBinary.add(Character.getNumericValue(character));
        }
        return eightBitBinary;
    }
}
