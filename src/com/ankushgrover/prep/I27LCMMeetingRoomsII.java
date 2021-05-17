package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/05/21
 */
public class I27LCMMeetingRoomsII {

    public static void main(String[] args) {
        I27LCMMeetingRoomsII obj = new I27LCMMeetingRoomsII();

        obj.findRotatedPoint(new int[]{8, 9, 2, 3, 4});
    }

    private int findRotatedPoint(int nums[]) {

        /*if(nums.length == 1)
            return 0;*/

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            System.out.println("Start: " + start + " end: " + end);

            int leftRef = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightRef = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];

            if ((nums[mid] > leftRef) && (nums[mid] > rightRef))
                return mid;

            if (nums[mid] >= nums[start])
                start = mid + 1;
            else end = mid - 1;
        }

        return 0;

    }

    private List<Interval> makeList(int[][] arr) {

        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] a = arr[i];
            list.add(new Interval(a[0], a[1]));
        }

        return list;

    }

    public int minMeetingRooms(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(a -> a.start));

        PriorityQueue<Interval> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));

        q.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {

            Interval cur = intervals.get(i);

            Interval last = q.poll();

            if (cur.start >= last.end) {
                last.end = cur.end;
                q.add(last);
            } else {
                q.add(cur);
            }
        }

        return q.size();

    }

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
