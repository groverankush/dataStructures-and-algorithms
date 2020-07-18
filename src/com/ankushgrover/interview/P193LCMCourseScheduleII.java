package com.ankushgrover.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 18/07/20
 * <p>
 * https://leetcode.com/problems/course-schedule-ii/
 * <p>
 * #medium #graph #dfs
 */
public class P193LCMCourseScheduleII {

    public static void main(String[] args) {
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] visited = new int[numCourses];
        int[] completed = new int[numCourses];


        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            List<Integer> list = map.getOrDefault(prerequisites[i][0], null);
            if (list == null) {
                list = new ArrayList<>();
                map.put(prerequisites[i][0], list);
            }
            list.add(prerequisites[i][1]);

        }
        List<Integer> result = new ArrayList<>();

        for (int element = 0; element < numCourses; element++) {
            if (!helper(map, visited, completed, element, result))
                return new int[0];
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;

    }

    private boolean helper(HashMap<Integer, List<Integer>> map, int[] visited, int[] completed, int selected, List<Integer> result) {

        List<Integer> list = map.getOrDefault(selected, null);

        if (visited[selected] == 1 && completed[selected] == 0)
            return false;

        if (visited[selected] == 1 && completed[selected] == 1)
            return true;

        visited[selected] = 1;

        if (list == null)
            list = new ArrayList<>();

        for (Integer e : list) {
            if (!helper(map, visited, completed, e, result))
                return false;
        }

        result.add(selected);
        completed[selected] = 1;

        return true;

    }


}
