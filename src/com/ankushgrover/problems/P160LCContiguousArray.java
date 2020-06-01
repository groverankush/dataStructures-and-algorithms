package com.ankushgrover.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/05/20
 */
public class P160LCContiguousArray {

    public static void main(String[] args) {

        P160LCContiguousArray obj = new P160LCContiguousArray();

        System.out.println(obj.findMaxLength(new int [] {0,0,1,0,0,0,1,1}));
    }

    // Wrong
    public int findMaxLength(int[] nums) {
        Stack<Node> stack = new Stack<>();

        for(int i = 0 ; i < nums.length; i++){

            if(!stack.isEmpty() && stack.peek().val != nums[i]){
                stack.pop();
            }
            else{
                stack.push(new Node(nums[i], i));
            }

        }
        int count = 0;
        int index = -1;
        for(Node node: stack){

            count = Math.max(count, (node.index - index) -1 );
            index = node.index;

        }
        if(!stack.isEmpty())
            count = Math.max(count, (nums.length-1 - index) -1 );
        else{
            count = Math.max(count, nums.length);
        }

        return  count ;
    }
    class Node{
        int val;
        int index = -1;

        Node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }


    public int findMaxLength1(int[] nums) {
        int maxsum = 0;
        int currsum = 0;
        Map<Integer, Integer> track = new HashMap<>();

        track.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            currsum += nums[i] == 0 ? -1 : nums[i];

            if(track.containsKey(currsum)){
                maxsum = Math.max(maxsum, i - track.get(currsum));
            } else {
                track.put(currsum, i);
            }

        }

        return maxsum;
    }
}
