package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RouteTrackerTest {

    RouteTracker routeTracker = new RouteTracker();

    @Test
    public void itShouldSayTheLinesDontCross() throws Exception {
        routeTracker.processInstruction(0, 5, 0, 0);
        Optional<Coordinates> optionalFoundHqCoordinates = routeTracker.processInstruction(5, 5, 0, 5);
        assertThat(optionalFoundHqCoordinates.isPresent(), is(false));
    }
}