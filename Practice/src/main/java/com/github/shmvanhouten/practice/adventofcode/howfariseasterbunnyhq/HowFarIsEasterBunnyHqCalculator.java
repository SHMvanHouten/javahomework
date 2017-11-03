package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.List;

public class HowFarIsEasterBunnyHqCalculator {

    Walker walker = new Walker();

    public Integer findDistanceToHq(String sequenceOfInstructions) {

        List<String> instructions = Arrays.asList(sequenceOfInstructions.split(", "));

        for (String instruction : instructions) {
            followInstruction(instruction);
        }

        return calculateDistance();
    }


    private void followInstruction(String instruction) {
        doTurn(instruction);
        // get direction walker is facing or get both starting coordinates and ending coordinates
        // get starting point from walker
        takeSteps(instruction);
        // get ending point from walker
        // make a line with the starting point and ending point, compare it to stored lines
        // if lines cross, get point where they cross and break out of the loop, return the coordinates
        // else (if lines don't cross) add the line to either vertical or horizontal lines map
    }

    private void doTurn(String instruction) {
        char turn = instruction.charAt(0);
        switch (turn) {
            case 'L':   walker.turnLeft();
                break;
            case 'R': walker.turnRight();
                break;

        }
    }

    private void takeSteps(String instruction) {
        walker.walk(determineLength(instruction));
    }

    private Integer determineLength(String instruction) {
        return valueOf(instruction.substring(1));
    }


    private int calculateDistance() {
        return abs(walker.getX()) + abs(walker.getY());
    }

    public static void main(String[] args) {
        HowFarIsEasterBunnyHqCalculator calculator = new HowFarIsEasterBunnyHqCalculator();

        String directions = "L3, R1, L4, L1, L2, R4, L3, L3, R2, R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2, L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1, L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51, L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5, L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3, R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1, L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4, R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1, L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5, R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4, L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3, R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5, L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2, L2, L3, R3, R3, R1";
        System.out.println(calculator.findDistanceToHq(directions));

    }
}
