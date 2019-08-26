package com.ankushgrover.problems;

import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/08/19
 *
 * https://leetcode.com/problems/min-stack/
 */
public class P58MinStack {

    public static void main(String[] args) {

        MinStack stack = new MinStack();

    }

    static class MinStack {

        int min;
        Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(x < min)
                min = x;
            stack.push(x);
        }

        public void pop() {
            int pop =  stack.pop();
            if(pop == min)
                findMin();
        }

        private void findMin(){
            min = Integer.MAX_VALUE;
            for(int i : stack){
                if(i < min)
                    min = i;
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
