package com.github.shmvanhouten.practice.binarycomparer;


import java.util.List;

public class BinaryComparer {
    private final IntToBinaryConverter binaryConverter;

    public BinaryComparer(IntToBinaryConverter binaryConverter) {
        this.binaryConverter = binaryConverter;
    }

    public int getAmountOfBitsToConvert(int firstNumber, int secondNumber) {
        List<Integer> firstBinaryNumber = binaryConverter.convertIntegerToBinary(firstNumber);
        List<Integer> secondBinaryNumber = binaryConverter.convertIntegerToBinary(secondNumber);
        int amountOfBitsToConvert = 0;
        for (int i = 0; i < firstBinaryNumber.size(); i++) {
            if(firstBinaryNumber.get(i) != secondBinaryNumber.get(i)){
                amountOfBitsToConvert++;
            }
        }
        return amountOfBitsToConvert;
    }
}
