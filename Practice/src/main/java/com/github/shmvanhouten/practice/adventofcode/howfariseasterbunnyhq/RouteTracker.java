package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

import java.util.Map;
import java.util.Optional;

public class RouteTracker {

    private Map<Integer, Map<Integer, Integer>> verticalLines;
    private Map<Integer, Map<Integer, Integer>> horizontalLines;


    public Optional<Coordinates> processInstruction(Integer xStart, Integer xEnd, Integer yStart, Integer yEnd) {
        if (xStart.equals(xEnd)){
            Map<Integer, Map<Integer, Integer>> newVerticalLine = buildLine(xStart, yStart, yEnd);
            boolean lineCrosses = compareVerticalLine(newVerticalLine);

        }else{

        }
        return Optional.empty();
    }

    private Map<Integer, Map<Integer, Integer>> buildLine(Integer xStart, Integer yStart, Integer yEnd) {
        return null;
    }

    private boolean compareVerticalLine(Map<Integer, Map<Integer, Integer>> newVerticalLine) {
        return false;
    }

}
