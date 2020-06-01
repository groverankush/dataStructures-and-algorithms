package com.ankushgrover.problems;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/05/20
 *
 * https://leetcode.com/problems/possible-bipartition/
 */
public class P161LCPossibleBipartition {

    public static void main(String[] args) {
        P161LCPossibleBipartition obj = new P161LCPossibleBipartition();
        int [][] arr= {{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(obj.possibleBipartition(5, arr));
    }

    public boolean possibleBipartition(int N, int [][] dislikes ){
        int arr [] = new int [N];

        for (int[] pair : dislikes) {
            if(arr[pair[0]-1] == 0 && arr[pair[1]-1] == 0 ){
                arr[pair[0]-1] = -1;
                arr[pair[1]-1] = 1;
            }else if(arr[pair[0]-1] != 0){
                if(arr[pair[1]-1] == arr[pair[0]-1])
                    return false;
                arr[pair[1]-1] = arr[pair[0]-1] == -1 ? 1 : -1;
            }else if(arr[pair[1]-1] != 0){
                if(arr[pair[1]-1] == arr[pair[0]-1])
                    return false;
                arr[pair[1]-1] = arr[pair[0]-1] == -1 ? 1 : -1;
            }else{
                if(arr[pair[0]-1] == arr[pair[1]-1])
                    return false;
            }
        }
        return true;
    }


    class Node{
        int value;
        boolean isFirst ;

        Node(int val, boolean isFirst){
            this.value = val;
            this.isFirst = isFirst;
        }
    }

    private void addToMap(HashMap<Integer, HashSet<Integer>> map, int key, int value) {
        HashSet<Integer> set = map.getOrDefault(key, null);
        if (set == null) {
            set = new HashSet<>();
            map.put(key, set);
        }
        set.add(value);
    }

}
