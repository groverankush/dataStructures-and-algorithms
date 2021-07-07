package com.ankushgrover.prep.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 29/06/21
 */
public class myntraShreya {

    public static void main(String[] args) {
        myntraShreya obj = new myntraShreya();
        obj.mainHello();


        /*List<Integer> list = Arrays.asList(5,7,9,13,11,6,6,3,3);
        long target = 12;
        //op : 3*/

        /*List<Integer> list = Arrays.asList(1,3,46,1,3,9);
        long target = 47;
        //op : 1*/

        /*List<Integer> list = Arrays.asList(6,6,3,9,3,5,1);
        long target = 12;
        //op : 2

        System.out.println(stockProfit(list, target));*/

        /*Stream words = Stream.of("one", "two", "three");
        int len = words.mapToInt(String::length).reduce(0, (len1, len2) -> len1+len2);*/

    }

    public static int stockProfit(List<Integer> list, long target) {

        HashMap<Long, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < list.size(); i++) {

            long profit = list.get(i);

            int occ = map.getOrDefault(target - profit, 0);

            if (map.containsKey(target - profit)) {
                if (occ > 0) {
                    occ--;
                    count++;
                    map.put(target - profit, occ);
                }
            } else {
                map.put(profit, map.getOrDefault(profit, 0) + 1);
            }

        }

        return count;

    }

    private void mainHello() {
        /*ArrayList l = new ArrayList();
        Test t1 = new Test();
        Test t2 = new Test();
        l.add(t1);
        l.add(t2);

        Collections.sort(l);

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }*/

        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("bcad");
        //System.out.println(number(2, list));
    }

    private int number(int n, String[] list) {
        HashSet<String> set = new HashSet<>();
        for (String s : list) {
            set.add(convert(s));
        }

        return set.size();
    }

    private String convert(String s) {
        int even[] = new int[26];
        int odd[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i % 2 == 0) {
                even[ch - 'a']++;
            } else {
                odd[ch - 'a']++;
            }

        }
        StringBuilder evenBuilder = new StringBuilder();
        StringBuilder oddBuilder = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (even[i] > 0) {
                evenBuilder.append('a' + i);
                evenBuilder.append(even[i]);
            }
            if (odd[i] > 0) {
                oddBuilder.append('a' + i);
                oddBuilder.append(odd[i]);
            }
        }

        res.append(evenBuilder);
        res.append("*");
        res.append(oddBuilder);
        return res.toString();
    }

    interface I1 {
        void method();
    }

    interface I2 {
        void method();
    }

    class Exception {

    }

    class Test implements I1, I2 {
        @Override
        public void method() {
            System.out.println("Method!!!");
        }
    }


}
