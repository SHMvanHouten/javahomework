package com.github.shmvanhouten;

public class SecondCharMoveDecrypter {
    public static String weaveTheSecondHalfWithFirst(String encryptedSentence) {
        StringBuilder stringBuilder = new StringBuilder(encryptedSentence);
        char[] firstHalfOfSentence = stringBuilder.substring(0,stringBuilder.length()/2).toCharArray();
        char[] secondHalfOfSentence = stringBuilder.substring(stringBuilder.length()/2).toCharArray();
        StringBuilder decryptedSentence = new StringBuilder();
        for (int i = 0; i < firstHalfOfSentence.length; i++){
            decryptedSentence.append(secondHalfOfSentence[i]);
            decryptedSentence.append(firstHalfOfSentence[i]);
        }
        if(encryptedSentence.length() % 2 != 0){
            decryptedSentence.append(secondHalfOfSentence[secondHalfOfSentence.length-1]);
        }
        return decryptedSentence.toString();
    }

    public static String decryptNTimes(String encryptedSentence, int n) {
        String decryptedSentence = encryptedSentence;
        for(int i = 0; i<n; i++){
            decryptedSentence = weaveTheSecondHalfWithFirst(decryptedSentence);
        }
        return decryptedSentence;
    }
}
