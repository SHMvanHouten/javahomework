package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

public class Walker {

    private Integer x = 0;
    private Integer y = 0;
    private Direction direction = Direction.NORTH;

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void walk(Integer steps) {
        switch (direction) {

            case NORTH: y += steps;
                break;
            case EAST: x += steps;
                break;
            case SOUTH: y -= steps;
                break;
            case WEST: x -= steps;
                break;
        }
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
