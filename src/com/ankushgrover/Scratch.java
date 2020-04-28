package com.ankushgrover;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Scratch {

    private String value = "";

    public static void main(String[] args) {

        Scratch obj = new Scratch();

        System.out.println("Hello" + obj.getFutureValue());

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
