package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/08/21
 */
public class I60LCHWildcardMatching {

    public static void main(String[] args) {

        I60LCHWildcardMatching obj = new I60LCHWildcardMatching();


        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String p = "a*******b";
        System.out.println("Answer is: " + obj.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        //return isStarOnly(p) || track(s, 0, p, 0);
        //return track(s.isEmpty() ? s+"A" : s, 0, p,0);
        int[][] memo = new int[s.length()][p.length()];
        return track(s, 0, p, 0, memo);
    }

    private boolean isStarOnly(String p) {
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) != '*')
                return false;

        return true;
    }

    private boolean track(String s, int si, String p, int pi, int[][] memo) {

        System.out.println("si: " + si + " pi: " + pi);
        if (pi == p.length() && si == s.length())
            return true;

        if (pi == p.length() || si > s.length())
            return false;

        if (pi < p.length() && si < s.length() && memo[si][pi] > 0) {
            return memo[si][pi] == 1;
        }

        char sc = si < s.length() ? s.charAt(si) : 'A';
        char pc = p.charAt(pi);

        boolean res = false;

        if (pc == '*') {
            res = track(s, si, p, pi + 1, memo)
                    || track(s, si + 1, p, pi, memo)
                    || track(s, si + 1, p, pi + 1, memo);
        } else if (pc == '?') {
            res = track(s, si + 1, p, pi + 1, memo);
        } else {
            if (sc == pc)
                res = track(s, si + 1, p, pi + 1, memo);
            else res = false;
        }

        if (pi < p.length() && si < s.length()) {
            memo[si][pi] = res ? 1 : 2;
        }

        return res;
    }
}
