package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/06/21
 * <p>
 * https://leetcode.com/problems/task-scheduler/
 */
public class I41LCMTaskScheduler {

    public static void main(String[] args) {

        I41LCMTaskScheduler obj = new I41LCMTaskScheduler();

        char tasks[] = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;
        System.out.println(obj.pq(tasks, n));

    }

    public int leastInterval(char[] tasks, int gapTime) {


        //return greedy(tasks, gapTime);
        return pq(tasks, gapTime);
    }


    private int pq(char[] tasks, int gapTime) {

        int[] map = new int[26];

        for (char ch : tasks) {
            map[ch - 'A']++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : map) {
            if (i > 0)
                q.add(i);
        }
        int time = 0;

        List<Integer> temp = new ArrayList<>();
        while (!q.isEmpty()) {


            for (int i = 0; i <= gapTime; i++) {

                if (q.isEmpty()) {
                    if (temp.size() > 0)
                        time++;
                } else {
                    int task = q.poll();
                    if (task > 1)
                        temp.add(task - 1);
                    time++;
                }
            }

            q.addAll(temp);
            temp.clear();
        }

        return time;

    }

    private int greedy(char[] tasks, int gapTime) {
        int[] map = new int[26];

        for (int i = 0; i < tasks.length; i++) {

            map[tasks[i] - 'A']++;

        }

        Arrays.sort(map);

        int max = map[25] - 1;
        int idle = max * gapTime;

        for (int i = 24; i >= 0; i--) {

            idle -= Math.min(map[i], max);

        }

        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}
