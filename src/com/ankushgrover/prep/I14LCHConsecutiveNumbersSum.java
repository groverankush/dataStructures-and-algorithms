package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 30/04/21
 */
public class I14LCHConsecutiveNumbersSum {

    public static void main(String[] args) {

        I14LCHConsecutiveNumbersSum obj = new I14LCHConsecutiveNumbersSum();

        System.out.println(obj.consecutiveNumbersSum(1000000000));
//933320757 -> 1866641512, now 933320755
        //1000000000 -> 1999999998 now 1000000000

    }

    public int consecutiveNumbersSum(int N) {

        if (N == 1 || N == 2)
            return 1;

        int start = 1;
        int end = 2;
        int count = 1;
        int sum = start + end;
        long iterations = 0;

        while (end <= (N / 2) + 1) {

            iterations++;
            if (sum < N) {
                end++;
                sum = sum + end;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            } else {
                count++;
                end++;
                sum = sum + end;
            }

        }

        System.out.println(iterations);

        return count;
    }
}
