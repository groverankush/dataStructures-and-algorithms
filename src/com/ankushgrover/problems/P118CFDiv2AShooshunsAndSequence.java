package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 18/09/19
 */
public class P118CFDiv2AShooshunsAndSequence {

    public static void main(String[] args) {
        P118CFDiv2AShooshunsAndSequence obj = new P118CFDiv2AShooshunsAndSequence();
        obj.run2();
    }

    private void run2() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int index = -1;
        int num = -1;
        int current;
        int kNum = -1;
        boolean kFound = false;


        for (int i = 0; i < n; i++) {
            current = in.nextInt();

            if (k - 1 == i) {
                kNum = current;
                if (current != num) {
                    index = k - 1;
                }
                kFound = true;
                kNum = current;
                continue;
            }

            if (kFound) {
                if (current != kNum) {
                    System.out.println(-1);
                    return;
                }

            } else {
                if (current != num) {
                    num = current;
                    index = i;
                }
            }

        }

        System.out.print(index);


    }

    private void run1() {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] map = new int[100001];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            list.add(num);
            map[num - 1] += 1;
        }

        if (map[list.get(0) - 1] == n) {
            System.out.print(0);
            return;
        }


        for (int i = 0; i < n; i++) {
            int num = list.get(k - 1);

            map[list.get(k - 1) - 1]++;

            if (map[list.get(0) - 1] == 1) {
                map[list.get(0) - 1] = 0;
            } else {
                map[list.get(0) - 1]--;
            }

            list.add(num);
            list.remove(0);


            if (map[num - 1] == n) {
                System.out.print(i + 1);
                return;
            }

        }

        System.out.print(-1);

    }

    private void run() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.get(list.get(0)) == n) {
            System.out.print(0);
            return;
        }


        for (int i = 0; i < n; i++) {
            int num = list.get(k - 1);

            map.put(list.get(k - 1), map.get(list.get(k - 1)) + 1);
            if (map.get(list.get(0)) == 1) {
                map.remove(list.get(0));
            } else {
                map.put(list.get(0), map.get(list.get(0)) - 1);
            }

            list.add(num);
            list.remove(0);


            if (map.get(num) == n) {
                System.out.print(i + 1);
                return;
            }

        }

        System.out.print(-1);

    }
}
