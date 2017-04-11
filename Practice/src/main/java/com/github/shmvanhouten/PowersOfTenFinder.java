package com.github.shmvanhouten;

public class PowersOfTenFinder {
    public String getStringOfWrittenOutPowersOfTen(int number) {
        String numberStringReversed = new StringBuilder(Integer.toString(number)).reverse().toString();
        String outputString = Character.toString(numberStringReversed.charAt(0));
        for (int i = 1; i<numberStringReversed.length(); i++) {
            char digit = numberStringReversed.charAt(i);
            if(digit>0){
                String tempString = Character.toString(digit);
                for(int j = 0; j < i; j++){
                    tempString = tempString.concat("0");
                }
                outputString = tempString.concat(" + " + outputString);
            }
        }
        return outputString;
    }
}
