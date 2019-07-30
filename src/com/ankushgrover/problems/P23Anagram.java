package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Because it was asked by Anurag's friend google's interview.
 */
public class P23Anagram {

    public static void main(String[] args) {
        int size = 10000;
        int[] a = new int[size];
        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
            b[i] = size - 1 - i;
        }

        long time = System.nanoTime();
        System.out.println("Anagram hash: " + isAnagramHash(a, b));
        System.out.println("Time: " + (System.nanoTime() - time));

        time = System.nanoTime();
        System.out.println("Anagram sort: " + isAnagram(a, b));
        System.out.println("Time: " + (System.nanoTime() - time));

        System.out.println("Anagram sentence: " + isAnagramSentence("blowing is wind", "wind is blowing"));

        System.out.println("Anagram word: " + isAnagram("hello", "hellp"));

    }


    private static boolean isAnagram(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    private static boolean isAnagramHash(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            Integer count = map.get(a[i]);

            if (count == null) {
                count = 0;
            }

            map.put(a[i], ++count);
        }

        for (int i = 0; i < b.length; i++) {
            Integer count = map.get(b[i]);

            if (count == null || count == 0)
                return false;

            map.put(b[i], --count);
        }

        return true;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            Integer count = map.get(a.charAt(i));
            if (count == null) {
                count = 0;
            }
            map.put(a.charAt(i), ++count);
        }

        for (int i = 0; i < b.length(); i++) {
            Integer count = map.get(b.charAt(i));
            if (count == null || count == 0)
                return false;

            map.put(b.charAt(i), --count);
        }

        return true;
    }

    private static boolean isAnagramSentence(String a, String b) {


        String[] arr = a.split(" ");
        String[] brr = b.split(" ");

        if (arr.length != brr.length)
            return false;

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : arr) {
            Integer count = map.get(str);

            if (count == null)
                count = 0;

            map.put(str, ++count);
        }

        for (String str : brr) {
            Integer count = map.get(str);

            if (count == null || count == 0)
                return false;

            map.put(str, --count);
        }

        return true;
    }


}
