package com.ankushgrover.prep.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/05/21
 */
public class P7AllConstruct {

    public static void main(String[] args) {

        P7AllConstruct obj = new P7AllConstruct();

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

            System.out.println("ConstructTabulation: " + tabulation(banks[i], target[i]));
            System.out.println("ConstructDP: " + constructDP(banks[i], target[i], new HashMap<>()));
            System.out.println("Construct: " + construct(banks[i], target[i]));


            System.out.println("*************************");


        }

    }

    private List<List<String>> construct(String[] bank, String target) {

        if (target.length() == 0) {
            List<List<String>> construct = new ArrayList<>();
            construct.add(new ArrayList<>());
            return construct;
        }


        List<List<String>> res = new ArrayList<>();

        for (String word : bank) {

            if (target.startsWith(word)) {
                String[] parts = target.split(word, 2);
                List<List<String>> constructs = construct(bank, parts[1]);
                for (List<String> list : constructs) {
                    List<String> temp = new ArrayList<>(list);
                    temp.add(0, word);
                    res.add(temp);
                }

            }

        }

        return res;

    }

    private List<List<String>> constructDP(String[] bank, String target, HashMap<String, List<List<String>>> memo) {

        if (target.length() == 0) {
            List<List<String>> construct = new ArrayList<>();
            construct.add(new ArrayList<>());
            return construct;
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }


        List<List<String>> res = new ArrayList<>();

        for (String word : bank) {

            if (target.startsWith(word)) {
                String[] parts = target.split(word, 2);
                List<List<String>> constructs = constructDP(bank, parts[1], memo);
                for (List<String> list : constructs) {
                    List<String> temp = new LinkedList<>(list);
                    temp.add(0, word);
                    res.add(temp);
                }

            }

        }

        memo.put(target, res);
        return res;

    }


    private List<List<String>> tabulation(String[] bank, String target) {

        List<List<String>>[] dp = new List[target.length() + 1];


        dp[0] = new ArrayList<>();

        dp[0].add(new ArrayList<>());

        for (int i = 0; i < dp.length; i++) {

            if (dp[i] != null) {

                for (int j = 0; j < bank.length; j++) {

                    String sub = target.substring(i);

                    if (sub.startsWith(bank[j])) {

                        int index = i + bank[j].length();

                        if (index < dp.length) {

                            List temp = dp[index];
                            if (temp == null) {

                                temp = new ArrayList<>();
                                dp[index] = temp;

                            }

                            for (List<String> list : dp[i]) {

                                List<String> copy = new ArrayList<>(list);
                                copy.add(bank[j]);
                                temp.add(copy);

                            }

                        }

                    }
                }

            }
        }

        return dp[target.length()];

    }
}
