package com.ankushgrover.contest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class C03 {

    public static void main(String[] args) throws ParseException {
        String date = "2004-12-29";
        System.out.println(dayOfYear(date));

        System.out.println(numRollsToTarget(30, 30, 500));
    }


    private static int actual(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = format.parse(date);
        calendar.setTime(dt);

        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Easy
     * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: date = "2019-01-09"
     * Output: 9
     * Explanation: Given date is the 9th day of the year in 2019.
     * Example 2:
     * <p>
     * Input: date = "2019-02-10"
     * Output: 41
     * Example 3:
     * <p>
     * Input: date = "2003-03-01"
     * Output: 60
     * Example 4:
     * <p>
     * Input: date = "2004-03-01"
     * Output: 61
     * <p>
     * <p>
     * Constraints:
     * <p>
     * date.length == 10
     * date[4] == date[7] == '-', and all other date[i]'s are digits
     * date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
     *
     * @param date
     * @return
     */
    private static int dayOfYear(String date) {


        String[] splits = date.split("-");

        int year = Integer.valueOf(splits[0]);

        boolean isLeap = isLeapYear(year);

        int month = Integer.valueOf(splits[1]);

        int days = 0;
        boolean isThirty = false;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                days = days + (isLeap ? 29 : 28);
            } else if (i == 7 || i == 8) {
                days += 31;
                isThirty = true;
                continue;
            } else {
                days = days + (isThirty ? 30 : 31);
            }

            isThirty = !isThirty;
        }

        return days + Integer.valueOf(splits[2]);
    }

    private static int numRollsToTarget(int d, int f, int target) {


        int start = 1;
        int end = f;

        long result = 0;


        if (d > 1) {

            while (start < end) {
                int sum = start + end;
                if (sum == target) {
                    result++;
                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                } else end--;

            }

            result = result * d;


            for (start = 1; start <= f; start++) {
                if ((start * d) == target)
                    result++;
            }
        }
        else{
            if(target <= f)
                result++;

            result = result * d;
        }
        int r = (int) (result % (Math.pow(10, 9) + 7));
        return r;


    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
