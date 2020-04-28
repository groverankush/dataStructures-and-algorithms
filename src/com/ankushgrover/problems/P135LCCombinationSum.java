package com.ankushgrover.problems;

public class P135LCCombinationSum {

    public static void main(String[] args) {

        P135LCCombinationSum obj = new P135LCCombinationSum();


        int[] arr = {10, 1, 2, 7, 6, 1, 5};

        // 1,1,2,5,6,7,10

        //obj.combinationSum(arr, 0, 0, 8, new ArrayList<>());

    }

/*    private ArrayList<ArrayList<Integer>> combinationSum(int [] arr, int start, int sum, int target, ArrayList<Integer> list){
        if(sum == target){
            ArrayList<ArrayList<Integer>> l = new ArrayList<>();
            l.add(list);
            return l;
        }

        if(start >= arr.length){

        }

        for(int i = start ; i < arr.length;i++){

            if(sum + arr[i] <= target){
                list.add(arr[i]);
                sum += arr[i];

                combinationSum(arr, start + 1, sum, target, list);


            }

        }


    }*/


}
