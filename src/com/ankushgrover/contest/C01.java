package com.ankushgrover.contest;

public class C01 {

    public static void main(String[] args) {

        //Output "DDDDD!UUUUURRR!DDDDDLLL!"
        // expected "DDDDD!UUUUURRR!DDDDLLLD!"

        //DDDDD!UUUUURRR!DDDDDLLL!
        //DDDDD!UUUUURRR!DDDDLLLD!
        System.out.println(alphabetBoardPath("bzb"));
    }

    /**
     * The Tribonacci sequence Tn is defined as follows:
     * <p>
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     * <p>
     * Given n, return the value of Tn.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 4
     * Output: 4
     * Explanation:
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     *
     * @param n
     * @return
     */
    private static int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;

        if (n == 0)
            return t0;

        if (n == 1)
            return t1;

        if (n == 2)
            return t2;

        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = result;
        }

        return result;

    }

    /**
     * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
     * <p>
     * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
     * <p>
     * We may make the following moves:
     * <p>
     * 'U' moves our position up one row, if the square exists;
     * 'D' moves our position down one row, if the square exists;
     * 'L' moves our position left one column, if the square exists;
     * 'R' moves our position right one column, if the square exists;
     * '!' adds the character board[r][c] at our current position (r, c) to the answer.
     * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: target = "leet"
     * Output: "DDR!UURRR!!DDD!"
     *
     * @param target
     * @return
     */
    public static String alphabetBoardPath(String target) {
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};

        StringBuilder builder = new StringBuilder();

        int x = 0;
        int y = 0;

        for (int i = 0; i < target.length(); i++) {

            char ch = target.charAt(i);


            int reqX = (ch - 'a') / 5;
            int reqY = (ch - 'a') - (board[reqX].charAt(0) - 'a');

            while (x != reqX || y != reqY) {

                while (y != reqY && !(x == 5 && reqY > 0)) {
                    if (y > reqY) {
                        y--;
                        builder.append('L');
                    }

                    if (y < reqY) {
                        y++;
                        builder.append('R');
                    }
                }

                while (x != reqX) {
                    if (x > reqX) {
                        x--;
                        builder.append('U');
                    }
                    if (x < reqX) {
                        x++;
                        builder.append('D');
                    }
                }
            }


            builder.append('!');

        }

        return builder.toString();
    }
}
