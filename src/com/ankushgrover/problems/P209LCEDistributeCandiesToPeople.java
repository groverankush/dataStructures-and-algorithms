package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 18/08/20
 * <p>
 * https://leetcode.com/problems/distribute-candies-to-people/
 * <p>
 * #easy
 */
public class P209LCEDistributeCandiesToPeople {

    public static void main(String[] args) {
    }

    public int[] distributeCandies(int candies, int num_people) {
        int arr[] = new int[num_people];

        int index = 0;
        int candy = 1;
        while (candies > 0) {

            candy = candies < candy ? candies : candy;
            arr[index] = arr[index] + candy;
            index = (++index) % num_people;
            candies -= candy;
            candy++;

        }

        return arr;
    }
}
