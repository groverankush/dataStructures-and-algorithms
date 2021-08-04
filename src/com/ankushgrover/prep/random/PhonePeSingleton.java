package com.ankushgrover.prep.random;

public class PhonePeSingleton {

    private static PhonePeSingleton instance = null;

    private PhonePeSingleton() {

    }

    public static PhonePeSingleton getInstance() {

        synchronized (PhonePeSingleton.class) {

        }

        if (instance == null) {
            synchronized (PhonePeSingleton.class) {
                if (instance == null)
                    instance = new PhonePeSingleton();
            }
        }

        return instance;
    }


}
