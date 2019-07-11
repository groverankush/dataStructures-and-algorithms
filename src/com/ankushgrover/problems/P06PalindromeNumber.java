package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class P06PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    private static boolean isPalindrome(int x) {

        if (x == 0)
            return true;

        if (x < 0 || x % 10 == 0)
            return false;

        int result = 0;

        while (x != 0) {
            result = (result + (x % 10));


            if (result == x || result == (x / 10))
                return true;

            x /= 10;
            result *= 10;

        }
        return false;

    }
}
