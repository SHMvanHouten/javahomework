package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

public enum Direction {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction turnLeft() {
        if (this == NORTH) {
            return WEST;
        } else  {
            return Direction.values()[this.ordinal()-1];
        }
    }


    public Direction turnRight() {
        if (this == WEST) {
            return NORTH;
        } else  {
            return Direction.values()[this.ordinal()+1];
        }
    }




}
