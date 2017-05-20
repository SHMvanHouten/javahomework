package com.github.shmvanhouten.practice;

import java.util.LinkedList;
import java.util.List;

class ReverseRotateChunks {
    public static String scrambleString(String unscrambledString, int chunkSize) {
        StringBuilder scrambledString = new StringBuilder("");
        List<String> chunks = divideStringIntoChunks(unscrambledString, chunkSize);
        for (String chunk : chunks) {
            if (isEvenSum(chunk)) {
                scrambledString.append(reverseChunk(chunk));
            } else {
                scrambledString.append(rotateChunk(chunk));
            }
        }
        return scrambledString.toString();
    }

    static String rotateChunk(String chunk) {
        String endOfString = chunk.substring(1);
        return endOfString.concat(String.valueOf(chunk.charAt(0)));
    }

    static String reverseChunk(String chunk) {
        return new StringBuilder(chunk).reverse().toString();
    }

    public static List<String> divideStringIntoChunks(String unscrambledString, int chunkSize) {
        List<String> chunks = new LinkedList<>();
        int index = 0;
        while (index + chunkSize <= unscrambledString.length()) {
            chunks.add(unscrambledString.substring(index, index + chunkSize));
            index += chunkSize;
        }
        return chunks;
    }

    private static boolean isEvenSum(String chunk) {
        int sum = 0;
        for (char digit : chunk.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum % 2 == 0;
    }
}
