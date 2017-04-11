package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TortoiseRaceTest{
    @Test
    public void itShouldCalculateTheAmountOfSecondsItWouldTakeForTortoiseAToCatchUpWithTortoiseB() throws Exception {
        TortoiseRace race = new TortoiseRace();
        assertThat(race.getSecondsNeededToCatchUp(20,40,20), is(360));
    }


}