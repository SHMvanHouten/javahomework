package com.github.shmvanhouten;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MoleculeToAtomsParserTest {

    @Test
    public void itShouldSay2OxygenAtomsAreInAnO2Molecule() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("O2");

        assertThat(atomMap.get("O"),is(2));
        assertThat("has 1 atom type", atomMap.size(), is(1));
    }

    @Test
    public void itShouldSay1FeAtomsAreInAFeMolecule() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("Fe");
        assertThat(atomMap.get("Fe"),is(1));
        assertThat("has 1 atom type", atomMap.size(), is(1));
    }

    @Test
    public void itShouldSay2HydrogenAtomsAnd1OxygenAtomForH2O() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("H2O");

        assertThat(atomMap.get("H"), is(2));
        assertThat(atomMap.get("O"),is(1));
        assertThat("has 2 atom types", atomMap.size(), is(2));
    }

    @Test
    public void itShouldHandleBrackets() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("Mg(OH)2");

        assertThat("H == 2",atomMap.get("H"), is(2));
        assertThat("O == 2",atomMap.get("O"),is(2));
        assertThat("Mg = 1",atomMap.get("Mg"), is(1));
        assertThat("has 3 atom types", atomMap.size(), is(3));
    }

    @Test
    public void itShouldHandleOtherTypeOfBrackets() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("K4[ON(SO3)2]2");
        for (String atom : atomMap.keySet()) {
            System.out.println(atom + " " + atomMap.get(atom));
        }
        assertThat("K == 4",atomMap.get("K"), is(4));
        assertThat("O == 14",atomMap.get("O"),is(14));
        assertThat("N = 2",atomMap.get("N"), is(2));
        assertThat("S = $",atomMap.get("S"), is(4));
        assertThat("has 4 atom types", atomMap.size(), is(4));
    }
}