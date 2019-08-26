package com.ankushgrover.problems;

/**
 *
 * Writing programming interview questions hasn't made me rich yet ... so I might give up and start trading Apple stocks all day instead.
 *
 * First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.
 *
 * So I grabbed Apple's stock prices from yesterday and put them in an array called stockPrices, where:
 *
 * The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
 * The values are the price (in US dollars) of one share of Apple stock at that time.
 * So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.
 *
 * Write an efficient method that takes stockPrices and returns the best profit I could have made from one purchase and one sale of one share of Apple stock yesterday.
 *
 * For example:
 *
 *   int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
 *
 * getMaxProfit(stockPrices);
 * // returns 6 (buying for $5 and selling for $11)
 *
 * No "shorting"—you need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
 *
 * https://www.interviewcake.com/question/python/stock-price
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class P01ApplesAndStocks {

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 8, 11, 9};

        System.out.println(applesAndStocks(arr));

        System.out.println(maxProfit(arr));
    }

    private static int applesAndStocks(int[] arr) {


        int profit = 0;
        int index = 1;
        int prev = 0;
        while (index < arr.length) {
            if (arr[index] - arr[prev] < profit) {
                prev++;
                index = prev + 1;
            } else {
                profit = arr[index] - arr[prev];
                index++;
            }
        }

        return profit;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {

        int max = 0;
        int ref = 0;
        int i = 1;
        while(i < prices.length){

            int diff =  prices[i] - prices[ref];

            if(diff < 0)
                ref = i;

            max = Math.max(diff, max);
            i++;
        }

        return max;

    }

}

