package com.ankushgrover.prep.dp;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/05/21
 */
public class P6CountConstruct {

    public static void main(String[] args) {

        P6CountConstruct obj = new P6CountConstruct();

        String[][] bob = {
                {"purp", "p", "ur", "le", "purpl"},
                {"ab", "abc", ",cd", "def", "abcd"},
                {"bo", "rd", ",ate", "t", "ska", "sk", "boar"},
                {"a", "p", "ent", "enter", "ot", "o", "t"},
                {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}};
        String[] targets = {"purple", "abcdef", "skateboard", "enterapotentpot", "eeeeeeeeeeeeeeeeeeeeeeeeeef"};

        obj.runAll(bob, targets);

    }

    private void runAll(String[][] banks, String[] target) {

        for (int i = 0; i < target.length; i++) {

            System.out.println("CountTabulation: " + tabulation(banks[i], target[i]));
            System.out.println("CountDP: " + countDP(banks[i], target[i], new HashMap<>()));
            System.out.println("Count: " + count(banks[i], target[i]));
            System.out.println("***********************");


        }

    }

    private int count(String[] bank, String target) {
        if (target.length() == 0)
            return 1;

        int count = 0;
        for (String word : bank) {

            if (target.startsWith(word)) {
                String[] parts = target.split(word, 2);
                count = count + count(bank, parts[1]);
            }
        }

        return count;
    }

    private int countDP(String[] bank, String target, HashMap<String, Integer> memo) {
        if (target.length() == 0)
            return 1;

        if (memo.containsKey(target))
            return memo.get(target);

        int count = 0;
        for (String word : bank) {

            if (target.startsWith(word)) {
                String[] parts = target.split(word, 2);
                count = count + countDP(bank, parts[1], memo);
            }
        }

        memo.put(target, count);

        return count;
    }

    private int tabulation(String[] bank, String target) {

        int[] dp = new int[target.length() + 1];

        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {

            if (dp[i] > 0) {

                String sub = target.substring(i);

                for (int j = 0; j < bank.length; j++) {

                    if (sub.startsWith(bank[j])) {
                        int index = i + bank[j].length();

                        if (index < dp.length) {
                            dp[index] += dp[i];
                        }
                    }

                }

            }

        }

        return dp[target.length()];
    }
}
