package com.github.shmvanhouten;

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
        StringBuilder element = new StringBuilder();
        StringBuilder quantity = new StringBuilder();
        while (i < molecule.length()){
            char ch = molecule.charAt(i);
            if('(' == ch){
                int indexOfClosingBracket = molecule.lastIndexOf(')');
                String tempMolecule = molecule.substring(i + 1, indexOfClosingBracket);
                Map<String, Integer> tempAtomMap = parse(tempMolecule);
                for (String key: tempAtomMap.keySet()) {
                    Integer quantityInSubstring = tempAtomMap.get(key) * numberAfterBrackets(molecule, indexOfClosingBracket);
                    atomMap.merge(key, quantityInSubstring, Integer::sum);
                }
                i += tempMolecule.length() -1;
            }
            if(isUpperCase(ch)){
                if(element.length()>0){
                    atomMap.put(element.toString(), getQuantity(quantity));
                }
                element = new StringBuilder();
                quantity = new StringBuilder();
                element.append(ch);
            }
            if(isDigit(ch)){
                quantity.append(ch);
            }
            if(isLowerCase(ch)){
                element.append(ch);
            }
            i++;
        }
        atomMap.put(element.toString(), getQuantity(quantity));
        return atomMap;
    }

    private int numberAfterBrackets(String molecule, int indexOfClosingBracket) {
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
