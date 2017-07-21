package com.github.shmvanhouten.practice.binarycomparer;


import java.util.List;
import java.util.Objects;

public class BinaryComparer {
    private final IntToBinaryConverter binaryConverter;

    public BinaryComparer(IntToBinaryConverter binaryConverter) {
        this.binaryConverter = binaryConverter;
    }

    public int getAmountOfBitsToConvert(int firstNumber, int secondNumber) {
        List<Integer> firstBinaryNumber;
        List<Integer> secondBinaryNumber;
        if(firstNumber >= secondNumber) {
            firstBinaryNumber = binaryConverter.convertIntegerToBinary(firstNumber);
            secondBinaryNumber = binaryConverter.convertIntegerToBinary(secondNumber, firstBinaryNumber.size());
        }else{
            secondBinaryNumber = binaryConverter.convertIntegerToBinary(secondNumber);
            firstBinaryNumber = binaryConverter.convertIntegerToBinary(firstNumber, secondBinaryNumber.size());
        }
        int amountOfBitsToConvert = 0;
        for (int i = 0; i < firstBinaryNumber.size(); i++) {
            if(!Objects.equals(firstBinaryNumber.get(i), secondBinaryNumber.get(i))){
                amountOfBitsToConvert++;
            }
        }
        return amountOfBitsToConvert;
    }
}
