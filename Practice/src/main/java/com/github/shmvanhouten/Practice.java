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

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public String changeFirstLetterOfEachWordToUpperCase(String string) {
        StringBuilder outputString = new StringBuilder("");
        String [] stringArray = string.split(" ");
        for (String word : stringArray) {
            StringBuilder wordBuilder = new StringBuilder(word);
            wordBuilder.setCharAt(0, Character.toUpperCase(wordBuilder.charAt(0)));
            outputString.append(wordBuilder).append(' ');
        }
        return outputString.toString().trim();
    }

    public int[] reverse8BitArray(int[] data) {
        for(int i=0; i<data.length/2; i+=8){
            int[] tempIntArray = new int[8];
            for(int j = 0; j<8; j++){
                tempIntArray[j] = data[i+j];
                data[i + j] = data[data.length - (i + (8 - j))];
                data[data.length - (i+(8-j))] = tempIntArray[j];
            }
        }
        return data;
    }

    public String getPhoneNumber(int[] numbers) {
        StringBuilder phoneNumber = new StringBuilder("(");
            for(int i =0; i<3; i++){
                phoneNumber.append(numbers[i]);
            }
        phoneNumber.append(") ");
        for(int i = 3; i<6; i++){
            phoneNumber.append(numbers[i]);
        }
        phoneNumber.append('-');
        for(int i = 6; i<numbers.length; i++){
            phoneNumber.append(numbers[i]);
        }

        return phoneNumber.toString();
    }

    public static String spinWordsOver4LettersLong(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        StringBuilder spinnedSentence = new StringBuilder();
        for (String word:sentenceArray) {
            if (word.length()>4){
                spinnedSentence.append(new StringBuilder(word).reverse()).append(' ');
            }else{
                spinnedSentence.append(word).append(' ');
            }
        }
        return spinnedSentence.toString().trim();
    }
}
