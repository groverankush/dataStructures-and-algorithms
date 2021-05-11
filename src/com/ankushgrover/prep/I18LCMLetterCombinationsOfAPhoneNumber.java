package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/05/21
 */
public class I18LCMLetterCombinationsOfAPhoneNumber {

    private static final String keypad[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        I18LCMLetterCombinationsOfAPhoneNumber obj = new I18LCMLetterCombinationsOfAPhoneNumber();
        System.out.println(obj.letterCombinations("23"));


    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        res.add("");
        generate(res, digits);

        return res;

    }

    private void generate(List<String> list, String digits) {

        if (digits.length() == 0)
            return;

        char digit = digits.charAt(0);
        digits = digits.substring(1, digits.length());

        String keys = keypad[digit - '0'];

        List<String> temp = new ArrayList<>();

        for (String string : list) {

            for (int i = 0; i < keys.length(); i++) {
                temp.add(string + keys.charAt(i));
            }

        }

        list.clear();
        list.addAll(temp);

        generate(list, digits);


    }
}
