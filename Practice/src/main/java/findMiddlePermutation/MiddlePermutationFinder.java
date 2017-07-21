package findMiddlePermutation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MiddlePermutationFinder {
    public String getMiddlePermutation(String str) {
        List<Character> characters = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.sort(characters);
        StringBuilder middlePermutationBuilder = new StringBuilder();
        int length = characters.size();
        if(length % 2 == 1){
            handleSituationIfStringSizeIsUneven(characters, middlePermutationBuilder, length);
        }else{
            handleSituationIfStringSizeIsEven(characters, middlePermutationBuilder, length);
        }
        return middlePermutationBuilder.toString();
    }

    private void handleSituationIfStringSizeIsEven(List<Character> characters, StringBuilder middlePermutationBuilder, int length) {
        appendAndRemoveCharForEvenString(characters, middlePermutationBuilder, length);
        appendRestOfCharactersInReverseOrder(characters, middlePermutationBuilder);
    }

    private void handleSituationIfStringSizeIsUneven(List<Character> characters, StringBuilder middlePermutationBuilder, int length) {
        appendAndRemoveCharForUnevenString(characters, middlePermutationBuilder, length);
        appendAndRemoveCharForEvenString(characters, middlePermutationBuilder, length);
        appendRestOfCharactersInReverseOrder(characters, middlePermutationBuilder);
    }

    private void appendAndRemoveCharForUnevenString(List<Character> characters, StringBuilder middlePermutationBuilder, int length) {
        middlePermutationBuilder.append(characters.get(length/2));
        characters.remove(length/2);
    }

    private void appendAndRemoveCharForEvenString(List<Character> characters, StringBuilder middlePermutationBuilder, int length) {
        int middleCharIndex = (length / 2) - 1;
        middlePermutationBuilder.append(characters.get(middleCharIndex));
        characters.remove(middleCharIndex);
    }

    private void appendRestOfCharactersInReverseOrder(List<Character> characters, StringBuilder middlePermutationBuilder) {
        for (int i = characters.size() - 1; i >= 0; i--) {
            middlePermutationBuilder.append(characters.get(i));
        }
    }
}
