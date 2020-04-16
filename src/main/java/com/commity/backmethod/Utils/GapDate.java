package com.commity.backmethod.Utils;

//import java.util.Date;

import java.util.Calendar;
import java.util.Date;

public class GapDate {
    public static Integer gapDistanceDay(Date startTime, Date endTime){

        long time1 = startTime.getTime();
        long time2 = endTime.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        return (int) (diff / (24 * 60 * 60 * 1000));
    }
    public static double getDistanceHour(Date startTime, Date endTime) {

        long time1 = startTime.getTime();
        long time2 = endTime.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        return (diff / (60 * 60 * 1000));
        //return hour;
    }
}
