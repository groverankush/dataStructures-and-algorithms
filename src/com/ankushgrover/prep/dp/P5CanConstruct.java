package com.ankushgrover.prep.dp;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/05/21
 */
public class P5CanConstruct {

    public static void main(String[] args) {

        P5CanConstruct obj = new P5CanConstruct();

        String[][] bob = {
                {"ab", "abc", ",cd", "def", "abcd"},
                {"bo", "rd", ",ate", "t", "ska", "sk", "boar"},
                {"a", "p", "ent", "enter", "ot", "o", "t"},
                {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}};
        String[] targets = {"abcdef", "skateboard", "enterapotentpot", "eeeeeeeeeeeeeeeeeeeeeeeeeef"};


        for (int i = 0; i < bob.length; i++) {
            obj.runAllSolutions(bob[i], targets[i]);
        }
    }

    private void runAllSolutions(String[] bank, String target) {

        System.out.println("Tabulation: " + tabulation(bank, target));
        System.out.println("topDownDP: " + topDownDP(bank, target, new HashMap<>()));
        System.out.println("topDown: " + topDown(bank, target));

        System.out.println("***************");
    }

    private boolean topDown(String[] wordBank, String target) {

        if (target.length() == 0)
            return true;


        boolean res = false;

        for (String word : wordBank) {

            if (target.startsWith(word)) {
                String[] parts = target.split(word, 2);
                res = res || topDown(wordBank, parts[1]);
            }

        }
        return res;
    }

    private boolean topDownDP(String[] wordBank, String target, HashMap<String, Boolean> memo) {

        if (target.length() == 0)
            return true;

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        boolean res = false;

        for (String word : wordBank) {

            if (target.startsWith(word)) {
                String[] parts = target.split(word, 2);
                res = res || topDownDP(wordBank, parts[1], memo);
            }

        }
        memo.put(target, res);
        return res;
    }

    private boolean tabulation(String[] bank, String target) {

        boolean[] dp = new boolean[target.length() + 1];

        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {

            if (dp[i]) {
                String sub = target.substring(i);
                for (String s : bank) {

                    if (sub.startsWith(s)) {


                        int index = i + s.length();

                        if (index < dp.length) {
                            dp[index] = true;
                        }
                    }

                }

            }

        }

        return dp[target.length()];

    }
}
