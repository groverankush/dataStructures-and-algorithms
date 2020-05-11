package com.ankushgrover.interview;

import java.util.HashSet;


/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/05/20
 * <p>
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 * <p>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 * <p>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class P148LCFindTheTownJudge {

    public static void main(String[] args) {
        P148LCFindTheTownJudge obj = new P148LCFindTheTownJudge();

    }


    // TODO Optimisation required
    public int findJudge(int N, int[][] trust) {
        int arr[] = new int[1000];
        HashSet<Integer> people = new HashSet<>();

        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][1] - 1]++;
            people.add(trust[i][0]);
        }
        for (int i = 0; i < 1000; i++) {
            if (arr[i] == N - 1 && !people.contains(i + 1))
                return i + 1;
        }
        return -1;
    }
}
