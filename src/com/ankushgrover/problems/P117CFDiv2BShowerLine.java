package com.ankushgrover.problems;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/09/19
 * <p>
 * http://codeforces.com/problemset/problem/431/B
 */
public class P117CFDiv2BShowerLine {

    public static void main(String[] args) {
        P117CFDiv2BShowerLine obj = new P117CFDiv2BShowerLine();
        obj.run2();
    }

    private void run2() {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<List<Integer>> perms = permutations(list);

        int[][] arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int sum;
        int max = 0;
        for (List<Integer> l : perms) {
            sum = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j += 2) {
                    sum = sum + arr[l.get(j)][l.get(j - 1)] + arr[l.get(j - 1)][l.get(j)];
                }
            }
            if (max < sum) {
                max = sum;
            }
        }

        System.out.println(max);

    }

    private List<List<Integer>> permutations(List<Integer> s) {

        if (s.size() == 1) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            List<Integer> l = new ArrayList<>(s);
            list.add(l);
            return list;
        }

        int first = s.get(0);
        s.remove(0);

        List<List<Integer>> perms = permutations(s);
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> perm : perms) {
            List<Integer> temp = new ArrayList<>(perm);

            for (int i = 0; i <= perm.size(); i++) {
                temp.add(i, first);
                result.add(new ArrayList<Integer>(temp));
                temp.remove(i);
            }
        }

        return result;

    }

    private void run1() {
        Scanner in = new Scanner(System.in);

        int[][] arr = new int[5][5];
        int[][] ref = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
                ref[i][j] = arr[i][j];
            }
        }

        int[] indexes = new int[5];
        int x = -1, y = -1;

        // Find max sum of 2
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (sum < arr[i][j] + arr[j][i]) {
                    sum = arr[i][j] + arr[j][i];
                    x = i;
                    y = j;
                }
            }
        }

        indexes[4] = x;
        indexes[3] = y;
        arr[x][y] = -1;
        arr[y][x] = -1;

        for (int i = 4; i > 2; i--) {
            Pair<Integer, Integer> p1 = findMax(arr[indexes[i]]);
            Pair<Integer, Integer> p2 = findMax(arr[indexes[i - 1]]);

            if (p2.getValue() < p1.getValue()) {
                int temp = indexes[i];
                indexes[i] = indexes[i - 1];
                indexes[i - 1] = temp;

                indexes[i - 2] = p1.getKey();
            } else indexes[i - 2] = p2.getKey();

        }

        sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j += 2) {
                sum = sum + ref[indexes[j]][indexes[j - 1]] + ref[indexes[j - 1]][indexes[j]];
            }
        }

        System.out.print(sum);


    }

    // Pair of index and max value
    private Pair<Integer, Integer> findMax(int[] arr) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        arr[index] = -1;
        return new Pair<>(index, max);
    }

    private void run() {
        Scanner in = new Scanner(System.in);

        int[][] arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                set.add(arr[i][j] + arr[j][i]);
            }
        }

        int[] nums = new int[5];
        int index = 4;
        Iterator<Integer> iterator = set.descendingIterator();
        while (iterator.hasNext() && index >= 0) {
            nums[index--] = iterator.next();
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j += 2) {
                sum = sum + nums[j] + nums[j - 1];
            }
        }

        System.out.print(sum);
    }


}
