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
    }

    @Test
    public void itShouldSay1FeAtomsAreInAFeMolecule() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("Fe");
        assertThat(atomMap.get("Fe"),is(1));
    }

    @Test
    public void itShouldSay2HydrogenAtomsAnd1OxygenAtomForH2O() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("H2O");
        assertThat(atomMap.get("H"), is(2));
        assertThat(atomMap.get("O"),is(1));
    }

    @Test
    public void itShouldHandleBrackets() throws Exception {
        MoleculeToAtomsParser parser = new MoleculeToAtomsParser();
        Map<String, Integer> atomMap = parser.parse("Mg(OH)2");
        assertThat(atomMap.get("H"), is(2));
        assertThat(atomMap.get("O"),is(2));
        assertThat(atomMap.get("Mg"), is(1));
    }
}