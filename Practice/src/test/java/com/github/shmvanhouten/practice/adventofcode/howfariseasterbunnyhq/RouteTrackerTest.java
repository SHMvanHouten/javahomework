package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RouteTrackerTest {

    private RouteTracker routeTracker = new RouteTracker();

    @Test
    public void itShouldSayTheLinesDoNotCross() throws Exception {
        routeTracker.processInstruction(0, 5, 0, 0);
        Optional<Coordinates> optionalFoundHqCoordinates = routeTracker.processInstruction(5, 5, 0, 5);
        assertThat(optionalFoundHqCoordinates.isPresent(), is(false));
    }

    @Test
    public void itShouldSayWhereTheLinesDoCross() throws Exception {
        routeTracker.processInstruction(0,5,0,0);
        routeTracker.processInstruction(5,5,0,3);
        routeTracker.processInstruction(5,1,3,3);
        Coordinates pointOfCrossing = routeTracker.processInstruction(1,1, 3, -2).get();
        assertThat(pointOfCrossing.getX(), is(1));
        assertThat(pointOfCrossing.getY(), is(0));
    }
}