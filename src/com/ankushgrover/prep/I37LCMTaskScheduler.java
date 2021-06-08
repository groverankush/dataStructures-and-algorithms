package com.ankushgrover.prep;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/06/21
 * <p>
 * ***************************** NOT COMPLETE *****************************************
 */
public class I37LCMTaskScheduler {

    public static void main(String[] args) {

        char[] arr = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int gapTime = 2;

        I37LCMTaskScheduler obj = new I37LCMTaskScheduler();
        //System.out.println(obj.leastInterval(arr, gapTime));

        System.out.println(obj.leastIntervalOpti(arr, gapTime));
    }

    public int leastIntervalOpti(char[] tasks, int gapTime) {

        HashMap<Character, Holder> map = new HashMap<>();

        for (char ch : tasks) {

            Holder holder = map.get(ch);
            if (holder == null) {
                holder = new Holder(ch);
                map.put(ch, holder);
            }
            holder.totalOccur++;

        }

        PriorityQueue<Holder> q = new PriorityQueue<>(map.values());

        int ct = 0;
        while (!q.isEmpty()) {
            Holder holder = q.poll();

            System.out.println("Element In Consideration " + holder.ch);

            boolean isConsidered = holder.consider(ct, gapTime);
            if (isConsidered) {
                ct++;
                System.out.print(holder.ch + " -> ");
            } else {
                int idle = gapTime - (ct - holder.lastTime);
                ct = ct + idle;

                System.out.print(" " + idle + "* Idle -> ");

                holder.consider(ct, gapTime);
                ct++;

                System.out.print(holder.ch + " -> ");
            }

            boolean shouldRemove = holder.shouldRemove();
            if (!shouldRemove) {
                q.add(holder);
            }
        }

        return ct;

    }


    class Holder implements Comparable<Holder> {

        char ch;
        int totalOccur;
        int lastTime = 0;

        Holder(char ch) {
            this.ch = ch;
        }

        boolean consider(int ct, int gapTime) {
            if (totalOccur > 0 && (lastTime == 0 || (ct - lastTime) >= gapTime)) {
                lastTime = ct + 1;
                totalOccur--;
                return true;
            }
            return false;
        }

        boolean shouldRemove() {
            return totalOccur <= 0;
        }

        @Override
        public int compareTo(Holder o) {
            int p = o.lastTime + o.totalOccur - (lastTime + totalOccur);
            System.out.println(ch + " vs " + o.ch + " Priority: " + p);

            return p;
        }
    }
}
