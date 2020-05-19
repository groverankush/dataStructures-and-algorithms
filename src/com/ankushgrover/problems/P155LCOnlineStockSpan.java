package com.ankushgrover.problems;

import javafx.util.Pair;

import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 19/05/20
 * <p>
 * https://leetcode.com/problems/online-stock-span/
 */
public class P155LCOnlineStockSpan {

    public static void main(String[] args) {
    }


    class StockSpanner {


        Stack<Pair<Integer, Integer>> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {

            int count = 1;
            while (!stack.isEmpty() && stack.peek().getKey() <= price) {
                Pair<Integer, Integer> pair = stack.pop();
                count += pair.getValue();
            }
            stack.push(new Pair<>(price, count));
            return count;

        }


    }
}
