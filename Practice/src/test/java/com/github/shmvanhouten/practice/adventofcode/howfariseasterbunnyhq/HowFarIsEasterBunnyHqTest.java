package com.github.shmvanhouten.practice.adventofcode.howfariseasterbunnyhq;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

public class HowFarIsEasterBunnyHqTest {

    HowFarIsEasterBunnyHqCalculator calculator = new HowFarIsEasterBunnyHqCalculator();

    @Test
    public void r1ShouldYield1() {
        assertThat(calculator.findDistanceToHq("R1"), is(1));
    }

    @Test
    public void r2shouldYield2() {
        assertThat(calculator.findDistanceToHq("R2"), is(2));
    }

    @Test
    public void r1r1ShouldYield2() {
        assertThat(calculator.findDistanceToHq("R1, R1"), is(2));
    }

    @Test
    public void l2l2ShouldYield4() {
        assertThat(calculator.findDistanceToHq("L2, L2"), is(4));
    }

    @Test
    public void firstExampleOfChallenge() {
        assertThat(calculator.findDistanceToHq("R2, R2, R2"), is(2));
    }

    @Test
    public void secondExampleOfChallenge() {
        assertThat(calculator.findDistanceToHq("R5, L5, R5, R3"), is(12));
    }

    @Test @Ignore("will fail with new rules")
    public void actualChallenge() throws Exception {
        String directions = "L5, R1, L5, L1, R5, R1, R1, L4, L1, L3, R2, R4, L4, L1, L1, R2, R4, R3, L1, R4, L4, L5, L4, R4, L5, R1, R5, L2, R1, R3, L2, L4, L4, R1, L192, R5, R1, R4, L5, L4, R5, L1, L1, R48, R5, R5, L2, R4, R4, R1, R3, L1, L4, L5, R1, L4, L2, L5, R5, L2, R74, R4, L1, R188, R5, L4, L2, R5, R2, L4, R4, R3, R3, R2, R1, L3, L2, L5, L5, L2, L1, R1, R5, R4, L3, R5, L1, L3, R4, L1, L3, L2, R1, R3, R2, R5, L3, L1, L1, R5, L4, L5, R5, R2, L5, R2, L1, L5, L3, L5, L5, L1, R1, L4, L3, L1, R2, R5, L1, L3, R4, R5, L4, L1, R5, L1, R5, R5, R5, R2, R1, R2, L5, L5, L5, R4, L5, L4, L4, R5, L2, R1, R5, L1, L5, R4, L3, R4, L2, R3, R3, R3, L2, L2, L2, L1, L4, R3, L4, L2, R2, R5, L1, R2";

        assertThat(calculator.findDistanceToHq(directions), is(226));
    }

    @Test
    public void R8R4R4R8ShouldYield4() throws Exception {

        assertThat(calculator.findDistanceToHq("R8, R4, R4, R8"), is(4));
    }
}
