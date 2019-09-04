package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/09/19
 * <p>
 * https://leetcode.com/problems/jump-game/
 */
public class P76JumpGame {

    public static void main(String[] args) {

    }

    private static boolean canJump(int[] nums) {

        int destination = nums.length - 1, current = nums.length - 1;

        while (current >= 0) {
            if (nums[current] >= (destination - current)) {
                destination = current;
            }

            current--;

        }

        return destination == 0;
    }
}
