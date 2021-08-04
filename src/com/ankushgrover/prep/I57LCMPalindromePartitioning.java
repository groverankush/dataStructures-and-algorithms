package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/07/21
 */
public class I57LCMPalindromePartitioning {

    public static void main(String[] args) {

        I57LCMPalindromePartitioning obj = new I57LCMPalindromePartitioning();
        System.out.println(obj.partition("a"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, res, new ArrayList<>());
        return res;
    }


    private void dfs(String s, int index, List<List<String>> res, List<String> cur) {

        if (index >= s.length()) {
            List<String> temp = new ArrayList<>(cur);
            res.add(temp);
            return;
        }

        boolean shouldBreak = false;

        for (int i = index; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (shouldBreak)
                    break;

                if (isPalindrome(s, i, j)) {
                    String sub = s.substring(i, j + 1);
                    cur.add(sub);
                    dfs(s, j + 1, res, cur);
                    cur.remove(cur.size() - 1);
                } else {
                    shouldBreak = true;
                    //System.out.println("Else");
                    break;
                }
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {

        int i = start;
        int j = end;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;

    }
}
