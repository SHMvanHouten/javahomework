package com.github.shmvanhouten;


public class Practice {
    public String getPositionInAlphabet(char alphabet) {
        Character referenceChar = '`';
        int position = Math.abs(referenceChar.compareTo(alphabet));
        return "Position of alphabet: "+ position;
    }

    public double roundToTwoDecimalPlaces(double number) {
        return Math.round(number*100d)/100d; //is inaccurate!
//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        return Double.parseDouble(decimalFormat.format(number)); is more accurate but because of Local configuration uses a ',' for a decimal point instead of a '.'
    }

    public char changeUpperCaseToLowerCase(char character) {
        return Character.toLowerCase(character);
    }

    public String changeAllLettersToOppositeCase(String inputString) {
        StringBuilder outputString = new StringBuilder();
//        for(int i = 0; i<inputString.length(); i++){
//            char letter = inputString.charAt(i);
//            if(Character.isUpperCase(letter)){
//                outputString += Character.toLowerCase(letter);
//            }else{
//                outputString += Character.toUpperCase(letter);
//            }
//
//        }
        for (char letter:inputString.toCharArray()) {
            if(Character.isUpperCase(letter)){
                outputString.append(Character.toLowerCase(letter));
            }else{
                outputString.append(Character.toUpperCase(letter));
            }
        }
        return outputString.toString();
    }
}
