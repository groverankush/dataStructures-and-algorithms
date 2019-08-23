package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 */
public class P49LoggerRateLimiter {

    public static void main(String[] args) {

        Logger logger = new Logger();

// logging string "foo" at timestamp 1
        logger.shouldPrintMessage(1, "foo"); //returns true;

// logging string "bar" at timestamp 2
        logger.shouldPrintMessage(2, "bar"); //returns true;

// logging string "foo" at timestamp 3
        logger.shouldPrintMessage(3, "foo"); //returns false;

// logging string "bar" at timestamp 8
        logger.shouldPrintMessage(8, "bar"); //returns false;

// logging string "foo" at timestamp 10
        logger.shouldPrintMessage(10, "foo"); //returns false;

// logging string "foo" at timestamp 11
        logger.shouldPrintMessage(11, "foo"); //returns true;

    }

    static class Logger {

        private HashMap<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public Logger() {

            map = new HashMap<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            int stamp = map.getOrDefault(message, -1);

            if (stamp == -1 || (timestamp - stamp >= 10)) {
                map.put(message, timestamp);
                return true;
            }

            return false;
        }
    }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
