package com.github.shmvanhouten;

public class TortoiseRace {
    public int getSecondsNeededToCatchUp(int tortoiseASpeed, int tortoiseBSpeed, int lead) {
        return (tortoiseBSpeed - tortoiseASpeed)/lead * 360;
    }
}
