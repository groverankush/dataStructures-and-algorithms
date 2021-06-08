package com.ankushgrover.prep;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/05/21
 */
public class I27LCMMeetingRoomsII {

    public static void main(String[] args) {
        I27LCMMeetingRoomsII obj = new I27LCMMeetingRoomsII();

        //priorityQueueCheck();

        int[][] arr = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[] start = {0, 5, 15};
        int[] end = {30, 10, 20};

        List<Interval> list = obj.makeList(arr);

        System.out.println(obj.minMeetingRoomsIntervalPq(list));
        System.out.println(obj.minMeetingRoomsArrayDoubleSorting(start, end));
    }

    static void priorityQueueCheck() {

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int asc[] = {1, 2, 3, 4, 5, 6};
        int dsc[] = {6, 5, 4, 3, 2, 1};

        for (int num : dsc) {
            q.add(num);
        }

        System.out.println(q);
        System.out.println("Poll: " + q.poll());


    }

    private List<Interval> makeList(int arr[][]) {

        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new Interval(arr[i][0], arr[i][1]));
        }

        return list;

    }

    public int minMeetingRoomsArrayDoubleSorting(int[] start, int end[]) {

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0;
        int rooms = 1;
        int j = 0;

        for (int i = 1; i < start.length; i++) {

            if (start[i] > end[j]) {
                j++;
            } else {
                rooms++;
            }
        }

        return rooms;


    }

    public int minMeetingRoomsIntervalPq(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(o -> o.start)); //TODO show full form

        PriorityQueue<Interval> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        q.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {

            Interval cur = intervals.get(i);
            Interval existing = q.poll();

            if (cur.start > existing.end) {
                existing.end = cur.end; // Not required if executing OR part
                q.add(existing); // Not required if executing OR part

                /******** OR ************
                 * q.add(curr)
                 * **********************/
            } else {
                q.add(cur);
                q.add(existing);
            }

        }

        return q.size();

    }


    public int minMeetingRooms(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(a -> a.start));

        //PriorityQueue<Interval> q1 = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

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
