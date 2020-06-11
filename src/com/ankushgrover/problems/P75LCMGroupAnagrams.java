package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/09/19
 * <p>
 * https://leetcode.com/problems/group-anagrams/
 *
 * #medium #hashMap #stringBuilder
 */
public class P75LCMGroupAnagrams {


    private static List<List<String>> groupAnagramsV2(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String arr = getSorted(s);

            if (!map.containsKey(arr))
                map.put(arr, new ArrayList<String>());
            map.get(arr).add(s);


        }

        return new ArrayList<>(map.values());

    }

    private static String getSorted(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            arr[index] = arr[index] + 1;
        }

        return Arrays.toString(arr);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<HashMap<Character, Integer>, List<String>> rMap = new HashMap<>();

        for (String str : strs) {

            HashMap<Character, Integer> map = getStringMap(str);

            List<String> temp = rMap.get(map);
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(str);
                rMap.put(map, temp);
            } else {
                temp.add(str);
            }
        }

        return new ArrayList<>(rMap.values());
    }

    private static HashMap<Character, Integer> getStringMap(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        return map;

    }

    public static void main(String[] args) {

        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};


        P75LCMGroupAnagrams obj = new P75LCMGroupAnagrams();
        System.out.println(obj.groupAnagramsV3(arr));

    }

    public List<List<String>> groupAnagramsV3(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            int[] arr = new int[26];
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }
            String key = getStringFromArray(arr);
            List<String> list = map.getOrDefault(key, null);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }

    private String getStringFromArray(int arr[]) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                s.append((char) ('a' + i));
                s.append(arr[i]);
            }
        }
        return s.toString();
    }
}
