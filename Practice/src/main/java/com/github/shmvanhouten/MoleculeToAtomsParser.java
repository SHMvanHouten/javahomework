package com.github.shmvanhouten;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Integer.parseInt;

public class MoleculeToAtomsParser {

    public Map<String, Integer> parse(String molecule) {
        Map<String, Integer> atomMap = new TreeMap<>();
        int i = 0;
        Map<Character, Character> brackets = getBracketsMap();
        StringBuilder element = new StringBuilder();
        StringBuilder quantity = new StringBuilder();
        while (i < molecule.length()){
            char ch = molecule.charAt(i);

            if(indicatesNewAtom(brackets, ch)){
                addAtomToList(atomMap, element, quantity);
                element = new StringBuilder();
                quantity = new StringBuilder();
            }

            if(isaBracket(ch, brackets)){
                int indexOfClosingBracket = molecule.lastIndexOf(brackets.get(ch));
                int numberAfterBrackets = getNumberAfterBrackets(molecule, indexOfClosingBracket);
                String tempMolecule = molecule.substring(i + 1, indexOfClosingBracket);
                parseBracketedMoleculePart(atomMap, numberAfterBrackets, tempMolecule);

                i += determineIndexToSkip(numberAfterBrackets, tempMolecule.length());
            }
            if(isDigit(ch)){
                quantity.append(ch);
            }else{
                element.append(ch);
            }
            i++;
        }
        addAtomToList(atomMap, element, quantity);
        return atomMap;
    }

    private boolean indicatesNewAtom(Map<Character, Character> brackets, char ch) {
        return isUpperCase(ch) || isaBracket(ch, brackets);
    }

    private int determineIndexToSkip(int numberAfterBrackets, int indexToSkip) {
        if(numberAfterBrackets>1){
            indexToSkip += 1;
        }
        if(numberAfterBrackets>10){
            indexToSkip+=1;
        }
        return indexToSkip;
    }

    private void parseBracketedMoleculePart(Map<String, Integer> atomMap, int numberAfterBrackets, String tempMolecule) {
        Map<String, Integer> tempAtomMap = parse(tempMolecule);
        for (String key: tempAtomMap.keySet()) {
            Integer quantityInSubstring = tempAtomMap.get(key) * numberAfterBrackets;
            atomMap.merge(key, quantityInSubstring, Integer::sum);
        }
    }

    private void addAtomToList(Map<String, Integer> atomMap, StringBuilder element, StringBuilder quantity) {
        if(element.length()>0){
            atomMap.put(element.toString(), getQuantity(quantity));
        }
    }

    private Map<Character,Character> getBracketsMap() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('[',']');
        brackets.put('{','}');
        return  brackets;
    }

    private boolean isaBracket(char ch, Map brackets) {
        return brackets.get(ch) != null;
    }

    private int getNumberAfterBrackets(String molecule, int indexOfClosingBracket) {
        String tempString = molecule.substring(indexOfClosingBracket + 1);
        StringBuilder numberAfterBrackets = new StringBuilder();
        int i = 0;
        while (i < tempString.length()) {
            char ch = tempString.charAt(i);
            if (isDigit(ch)) {
                numberAfterBrackets.append(ch);
            } else {
                break;
            }
            i++;
        }
            return getQuantity(numberAfterBrackets);
    }

    private int getQuantity(StringBuilder quantity) {
        if(quantity.length()==0){
            return 1;
        }
        return parseInt(quantity.toString());
    }
}
