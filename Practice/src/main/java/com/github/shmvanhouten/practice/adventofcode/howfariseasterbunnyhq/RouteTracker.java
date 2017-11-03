package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

import java.util.*;

public class RouteTracker {

    private Map<Integer, List<Line>> verticalLines = new HashMap<>();
    private Map<Integer, List<Line>> horizontalLines = new HashMap<>();


    public Optional<Coordinates> processInstruction(Integer xStart, Integer xEnd, Integer yStart, Integer yEnd) {

        if (xStart.equals(xEnd)) {
            Line newVerticalLine = buildLine(yStart, yEnd);
            if (verticalLines.isEmpty() || horizontalLines.isEmpty()) {
                verticalLines.put(xStart, Arrays.asList(newVerticalLine));
                return Optional.empty();
            } else {
                return compareAndProcessLine(xStart, newVerticalLine, verticalLines, horizontalLines);
            }
        } else {
            Line newHorizontalLine = buildLine(xStart, xEnd);
            if (verticalLines.isEmpty() || horizontalLines.isEmpty()) {
                horizontalLines.put(yStart, Arrays.asList(newHorizontalLine));
                return Optional.empty();
            } else {
                return compareAndProcessLine(yStart, newHorizontalLine, horizontalLines, verticalLines);
            }

        }
    }

    private Line buildLine(Integer start, Integer end) {
        //process start so the starting coordinate doesn't coincide with the previous instructions ending coordinate.
        if (start > end) {
            return new Line(end, start - 1);
        } else {
            return new Line(start + 1, end);
        }
    }

    private Optional<Coordinates> compareAndProcessLine(Integer linePosition, Line newVerticalLine, Map<Integer, List<Line>> parallelLines, Map<Integer, List<Line>> perpendicularLines) {

        Optional<Integer> possibleCrossingPoint = compareLineToParallelLines(linePosition, newVerticalLine, parallelLines);
        if (possibleCrossingPoint.isPresent()) {
            return Optional.of(new Coordinates(linePosition, possibleCrossingPoint.get()));
        }

        possibleCrossingPoint = compareLineToPerpendicularLines(linePosition, newVerticalLine, perpendicularLines);
        if (possibleCrossingPoint.isPresent()) {
            return Optional.of(new Coordinates(linePosition, possibleCrossingPoint.get()));
        }

        addLineToExistingLineMap(linePosition, newVerticalLine, parallelLines);

        return Optional.empty();
    }

    private void addLineToExistingLineMap(Integer linePosition, Line newVerticalLine, Map<Integer, List<Line>> existingLineMap) {
        if (existingLineMap.containsKey(linePosition)) {
            List<Line> lines = existingLineMap.get(linePosition);
            lines.add(newVerticalLine);
            existingLineMap.put(linePosition, lines);
        } else {
            existingLineMap.put(linePosition, Arrays.asList(newVerticalLine));
        }
    }

    private Optional<Integer> compareLineToPerpendicularLines(Integer linePosition, Line newLine, Map<Integer, List<Line>> perpendicularLines) {

        for (int stepInLine = newLine.getLineStart(); stepInLine <= newLine.getLineEnd(); stepInLine++) {
            if (perpendicularLines.containsKey(stepInLine)) {
                for (Line line : perpendicularLines.get(stepInLine)) {
                    if (line.getLineStart() <= linePosition && line.getLineEnd() >= linePosition) {
                        return Optional.of(stepInLine);
                    }
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Integer> compareLineToParallelLines(Integer linePosition, Line newLine, Map<Integer, List<Line>> perpendicularLines) {
        return Optional.empty();
        //todo: finish this.
    }

}
