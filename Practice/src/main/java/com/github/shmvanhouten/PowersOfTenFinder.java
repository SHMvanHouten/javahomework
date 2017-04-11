package com.github.shmvanhouten;

public class PowersOfTenFinder {
    public String getStringOfWrittenOutPowersOfTen(int num) {
        StringBuilder numberStringReversed = new StringBuilder(Integer.toString(num)).reverse();
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i<numberStringReversed.length(); i++) {
            int digit = Character.getNumericValue(numberStringReversed.charAt(i));
            if(digit>0){
                StringBuilder tempString = new StringBuilder(Character.toString(numberStringReversed.charAt(i)));
                for(int j = 0; j < i; j++){
                    tempString = tempString.append("0");
                }
                outputString = tempString.append(" + " + outputString);
            }
        }
        outputString = outputString.delete(outputString.length()-3, outputString.length());
        return outputString.toString();
    }
}
