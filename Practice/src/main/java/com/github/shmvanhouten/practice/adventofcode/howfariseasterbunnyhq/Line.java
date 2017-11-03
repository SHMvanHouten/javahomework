package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

public class Line {
    private final Integer lineStart;
    private final Integer lineEnd;

    public Line(Integer lineStart, Integer lineEnd) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }

    public Integer getLineStart() {
        return lineStart;
    }

    public Integer getLineEnd() {
        return lineEnd;
    }
}
