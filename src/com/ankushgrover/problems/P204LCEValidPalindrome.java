package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/08/20
 */
public class P204LCEValidPalindrome {

    public static void main(String[] args) {
    }

    public boolean isPalindrome(String s) {
        boolean res = true;

        int start = 0, end = s.length() - 1;

        while (start <= end) {

            switch (getStatus(s.charAt(start), s.charAt(end))) {

                case 0:
                    start++;
                    end--;
                    break;
                case 1:
                    start++;
                    break;
                case 2:
                    end--;
                    break;
                default:
                    return false;

            }
        }

        return true;
    }

    private int getStatus(char a, char b) {

        if (Character.toLowerCase(a) == Character.toLowerCase(b))
            return 0;

        if (!(Character.isDigit(a) || Character.isAlphabetic(a)))
            return 1;

        if (!(Character.isDigit(b) || Character.isAlphabetic(b)))
            return 2;

        return -1;

    }
}
