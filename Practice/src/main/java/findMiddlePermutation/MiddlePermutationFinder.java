package findMiddlePermutation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MiddlePermutationFinder {
    public String getMiddlePermutation(String str) {
        List<Character> characters = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        StringBuilder middlePermutationBuilder = new StringBuilder();
        int length = characters.size();
        if(length % 2 == 1){
            middlePermutationBuilder.append(characters.get(length/2));
            middlePermutationBuilder.append(characters.get((length/2) -1));
            characters.remove(length/2);
            characters.remove((length/2) -1);
            for (int i = characters.size() - 1; i >= 0; i--) {
                middlePermutationBuilder.append(characters.get(i));
            }
        }
        return middlePermutationBuilder.toString();
    }
}
