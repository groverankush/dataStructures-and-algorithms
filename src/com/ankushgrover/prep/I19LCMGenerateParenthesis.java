package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 09/05/21
 */
public class I19LCMGenerateParenthesis {

    public static void main(String[] args) {

        I19LCMGenerateParenthesis obj = new I19LCMGenerateParenthesis();
        System.out.println(obj.generateParenthesis(2));

    }


    public List<String> generateParenthesis(int n) {

        List<Holder> holders = new ArrayList<>();
        holders.add(new Holder("", 0));
        makeList(holders, 2 * n, 2 * n);

        List<String> result = new ArrayList<String>();
        for (Holder holder : holders) {

            System.out.println(holder.str + " " + holder.value);

            result.add(holder.str);
        }

        return result;

    }

    private void makeList(List<Holder> holders, int size, int totalSize) {

        if (size <= 0) {
            List<Holder> temp = new ArrayList<>();
            for (Holder holder : holders) {

            }
            return;
        }


        List<Holder> temp = new ArrayList<>();
        for (Holder holder : holders) {
            addIfRequired(holder, '(', totalSize, temp);
            addIfRequired(holder, ')', totalSize, temp);
        }

        holders.clear();
        holders.addAll(temp);

        makeList(holders, --size, totalSize);

    }

    private void addIfRequired(Holder currentHolder, char bracket, int totalSize, List<Holder> list) {
        Holder holder = new Holder(currentHolder, bracket);

        if (holder.value >= 0 && holder.value <= totalSize - (holder.str.length())) {
            list.add(holder);
        }
    }


    class Holder {
        String str;
        int value;

        Holder(String str, int value) {
            this.str = str;
            this.value = value;
        }

        Holder(Holder holder, char bracket) {

            this.str = holder.str + bracket;
            this.value = holder.value + (bracket == '(' ? 1 : -1);

        }
    }
}
