package com.ankushgrover.interview;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/08/20
 * <p>
 * https://leetcode.com/problems/detect-capital/
 * <p>
 * #easy
 */
public class P203LCEDetectCapital {

    public static void main(String[] args) {
    }

    public boolean detectCapitalUse(String word) {
        boolean isSmallFound = false;
        boolean isCapsFound = false;
        boolean isMultipleCapsFound = false;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                isSmallFound = true;
            } else {
                if (isCapsFound)
                    isMultipleCapsFound = true;
                isCapsFound = true;
            }
        }

        return ((isCapsFound && !isSmallFound)
                || (isSmallFound && !isCapsFound)
                || (isCaps(word.charAt(0)) && !isMultipleCapsFound));
    }

    boolean isCaps(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
