package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/09/19
 * <p>
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class P85MeetingRooms {

    public static void main(String[] args) {
    }

    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int end[] = new int[intervals.length];

        int rooms = 0;

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int index = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[index]) {
                rooms++;
            } else {
                index++;
            }
        }

        return rooms;
    }
}
