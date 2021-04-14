package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/08/20
 * <p>
 * https://leetcode.com/problems/fizz-buzz/
 * <p>
 * #easy
 */
public class P214LCEFizzBuzz {

    public static void main(String[] args) {
    }

    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            StringBuilder builder = new StringBuilder();

            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0)
                    builder.append("Fizz");
                if (i % 5 == 0)
                    builder.append("Buzz");
            } else {
                builder.append(i);
            }

            res.add(builder.toString());


        }

        return res;

    }
}
