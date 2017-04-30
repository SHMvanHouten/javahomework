package com.github.shmvanhouten.practice;

import com.github.shmvanhouten.practice.TortoiseRace;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TortoiseRaceTest{
    @Test
    public void itShouldCalculateTheAmountOfSecondsItWouldTakeForTortoiseAToCatchUpWithTortoiseB() throws Exception {
        TortoiseRace race = new TortoiseRace();
        assertThat(race.getSecondsNeededToCatchUp(20,40,20), is(3600));
    }

    @Test
    public void itShouldTurnSecondsIntoHoursMinutesAndSeconds() throws Exception{
        TortoiseRace race = new TortoiseRace();
        assertThat(race.convertSecondsIntoHoursMinutesAndSeconds(3600), is(new int[]{1,0,0}));
    }

    @Test
    public void itShouldGiveTheHoursMinutesAndSecondsItWillTakeToCatchUp() throws Exception{
        TortoiseRace race = new TortoiseRace();
        assertThat(race.getTimeNeededToCatchUp(40, 60, 20), is(new int[]{1, 0, 0}));
        assertThat(race.getTimeNeededToCatchUp(40, 50, 20), is(new int[]{2, 0, 0}));
        assertThat(race.getTimeNeededToCatchUp(10, 50, 20), is(new int[]{0, 30, 0}));
        assertThat(race.getTimeNeededToCatchUp(720, 850, 70), is(new int[]{0, 32, 18}));
    }


}