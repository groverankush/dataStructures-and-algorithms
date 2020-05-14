package com.ankushgrover;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Scratch {

    private String value = "";

    public static void main(String[] args) {

        System.out.println("[],[\"app\"],[\"apple\"],[\"beer\"],[\"add\"],[\"jam\"],[\"rental\"],[\"apps\"],[\"app\"],[\"ad\"],[\"applepie\"],[\"rest\"],[\"jan\"],[\"rent\"],[\"beer\"],[\"jam\"],[\"apps\"],[\"app\"],[\"ad\"],[\"applepie\"],[\"rest\"],[\"jan\"],[\"rent\"],[\"beer\"],[\"jam\"]".replaceAll("\\[", "").replaceAll("\\]", ""));

        Scratch obj = new Scratch();

        obj.complement(1);
    }



    private void complement(int n){
        // Find number of bits in the
        // given integer
        int number_of_bits =
                (int)(Math.floor(Math.log(n) /
                        Math.log(2))) + 1;

        // XOR the given integer with poe(2,
        // number_of_bits-1 and print the result
        System.out.println(((1 << number_of_bits) - 1) ^ n) ;
    }

    private String getFutureValue() {

        FutureTask<String> task = new FutureTask<String>(() -> {
            value = "Working as expected";
            return value;
        });

        Executors.newSingleThreadExecutor().submit(task);

        try {
            return task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "InterruptedException";
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "ExecutionException";
        }

    }


}
