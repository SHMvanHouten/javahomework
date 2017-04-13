package com.github.shmvanhouten;

public class SecondCharMoveEncrypter {

    public static String moveEverySecondCharToTheFront(String sentence) {
        StringBuilder encryptedSentence = new StringBuilder();
        StringBuilder encryptedSentenceRemaining = new StringBuilder();
        char[] sentenceArray = sentence.toCharArray();
        for(int i = 0; i<sentenceArray.length; i++){
            if(i%2 == 0){
                encryptedSentenceRemaining.append(sentenceArray[i]);
            }else{
                encryptedSentence.append(sentenceArray[i]);
            }
        }
        return encryptedSentence.append(encryptedSentenceRemaining).toString();
    }

    public static String encryptNTimes(int n, String sentence) {
        String encryptedSentence = sentence;
        for(int i = 0; i < n; i++){
            encryptedSentence = moveEverySecondCharToTheFront(encryptedSentence);
        }
        return encryptedSentence;
    }
}
