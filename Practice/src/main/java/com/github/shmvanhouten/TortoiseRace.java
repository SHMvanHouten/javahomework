package com.github.shmvanhouten;
import java.time.Duration.*;

public class TortoiseRace {
    int getSecondsNeededToCatchUp(int tortoiseASpeed, int tortoiseBSpeed, int lead) {
        return lead* 3600/(tortoiseBSpeed - tortoiseASpeed);
    }

    public int[] convertSecondsIntoHoursMinutesAndSeconds(int seconds) {
        int[] hourMinuteSecondArray = new int[]{0,0,0};
        hourMinuteSecondArray[0] = seconds/3600;
        seconds -= hourMinuteSecondArray[0]*3600;
        hourMinuteSecondArray[1] = seconds/60;
        hourMinuteSecondArray[2] = seconds - hourMinuteSecondArray[1]*60;
        return hourMinuteSecondArray;
    }

    public int[] getTimeNeededToCatchUp(int tortoiseASpeed, int tortoiseBSpeed, int lead) {
        return convertSecondsIntoHoursMinutesAndSeconds(getSecondsNeededToCatchUp(tortoiseASpeed, tortoiseBSpeed, lead));
    }

    public static int[] race(int tortoiseASpeed, int tortoiseBSpeed, int lead){
        int secondsNeededToCatchUp = lead * 3600/(tortoiseBSpeed - tortoiseASpeed);
        int[] hourMinuteSecondArray = new int[]{0,0,0};
        hourMinuteSecondArray[0] = secondsNeededToCatchUp/3600;
        secondsNeededToCatchUp -= hourMinuteSecondArray[0]*3600;
        hourMinuteSecondArray[1] = secondsNeededToCatchUp/60;
        hourMinuteSecondArray[2] = secondsNeededToCatchUp - hourMinuteSecondArray[1]*60;
        return hourMinuteSecondArray;
    }
}
