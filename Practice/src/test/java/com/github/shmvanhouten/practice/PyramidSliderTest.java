package com.github.shmvanhouten.practice;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PyramidSliderTest {

    @Test
    public void itShouldFindTheFirstPathDown() throws Exception {
        PyramidSlider pathfinder = new PyramidSlider();
        int[][] pyramid = makePyramid();
        assertThat(pathfinder.calculateBiggestPath(pyramid), is(10));
    }

    private int[][] makePyramid() {
        return new int[][]{new int[]{3},
                new int[]{2,1},
                new int[]{5,3,1}
        };
    }
}