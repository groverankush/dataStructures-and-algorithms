package com.ankushgrover.practice;

public class Backtracking {

    public static void main(String[] args) {
        boolean [] arr = new boolean[4];

        queenPermutation(arr, 0, 2, "");
    }

    /**
     * Count the total number of ways to place {@code tq} queens on an n sized boolean array
     *
     * @param boxes
     * @param qpsf: Queens places so far.
     * @param tq: total no. of queens.
     * @param ans: Answer
     */
    private static void queenPermutation(boolean [] boxes, int qpsf, int tq, String ans){

        if(qpsf == tq){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < boxes.length; i++){

            if(boxes[i] == false){
                boxes[i] = true;
                queenPermutation(boxes, qpsf + 1, tq, ans + String.format("q%db%d", qpsf,i));
                boxes[i] = false;
            }


        }

    }
}
