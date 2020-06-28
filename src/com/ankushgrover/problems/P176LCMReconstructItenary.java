package com.ankushgrover.problems;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/06/20
 * <p>
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class P176LCMReconstructItenary {

    HashMap<String, PriorityQueue<String>> map;
    LinkedList<String> list;

    public static void main(String[] args) {
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        list = new LinkedList<>();

        for (List<String> ticket : tickets) {

            PriorityQueue<String> q = map.getOrDefault(ticket.get(0), null);
            if (q == null) {
                q = new PriorityQueue<>();
                map.put(ticket.get(0), q);
            }
            q.add(ticket.get(1));
        }


        makePlan("JFK");
        return list;
    }


    private void makePlan(String start) {

        PriorityQueue<String> q = map.get(start);
        while (q != null && !q.isEmpty()) {
            makePlan(q.poll());
        }
        list.addFirst(start);

    }

    private List<String> makePlan(String start, HashMap<String, PriorityQueue<String>> map, List<String> list) {

        if (map.size() == 0) {
            return list;
        }

        PriorityQueue<String> q = map.getOrDefault(start, null);


        if (q == null || q.size() == 0)
            return null;

        List<String> qList = new ArrayList<>(q);


        boolean flag = false;
        for (String s : qList) {

            list.add(s);
            q.remove(s);
            List<String> l = makePlan(s, map, list);
            if (l == null) {
                q.add(s);
                list.remove(list.size() - 1);
            } else {
                flag = true;
                break;
            }
        }

        return flag ? list : null;
    }
}
