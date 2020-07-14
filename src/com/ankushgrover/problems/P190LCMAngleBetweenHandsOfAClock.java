package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/07/20
 * <p>
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 * <p>
 * #medium
 */
public class P190LCMAngleBetweenHandsOfAClock {

    public static void main(String[] args) {
    }

    public double angleClock(int hour, int minutes) {

        double degreesOfHourHandIn1Min = 0.5f;
        double degreesOfHourHandIn1Hour = 30f;
        double degreesOfMinHandIn1Min = 6f;

        double value = Math.abs((minutes * degreesOfMinHandIn1Min) - (degreesOfHourHandIn1Hour * hour + (degreesOfHourHandIn1Min * minutes)));


        return Math.min(value, 360 - value);
    }
}
