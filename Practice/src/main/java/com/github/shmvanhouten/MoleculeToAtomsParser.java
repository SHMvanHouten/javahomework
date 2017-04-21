package com.github.shmvanhouten;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.Character.isDigit;
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
                    atomMap.merge(key,tempAtomMap.get(key), Integer::sum);
                }
            }
            if(isUpperCase(ch)){
                atomMap.put(element.toString(), getQuantity(quantity));
                element = new StringBuilder();
                quantity = new StringBuilder();
            }
            if(isDigit(ch)){
                quantity.append(ch);
            }else{
                element.append(ch);
            }
            i++;
        }
        atomMap.put(element.toString(), getQuantity(quantity));
        return atomMap;
    }

    private int getQuantity(StringBuilder quantity) {
        if(quantity.length()==0){
            return 1;
        }
        return parseInt(quantity.toString());
    }
}
