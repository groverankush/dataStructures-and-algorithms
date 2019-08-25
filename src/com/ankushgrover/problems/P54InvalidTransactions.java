package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/08/19
 */
public class P54InvalidTransactions {

    public static void main(String[] args) {

        //["bob,689,1910,barcelona","bob,832,1726,barcelona","bob,820,596,bangkok"]
        String[] arr = {"xnova,261,1949,chicago","bob,206,1284,chicago","xnova,420,996,bangkok","chalicefy,704,1269,chicago","iris,124,329,bangkok","xnova,791,700,amsterdam","chalicefy,572,697,budapest","chalicefy,231,310,chicago","chalicefy,763,857,chicago","maybe,837,198,amsterdam","lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","lee,607,275,budapest","chalicefy,709,1171,amsterdam"};


        //["xnova,261,1949,chicago","bob,206,1284,chicago","chalicefy,704,1269,chicago","chalicefy,763,857,chicago","lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","chalicefy,709,1171,amsterdam"]
        //["bob,132,1219,barcelona","chalicefy,763,857,chicago","xnova,261,1949,chicago","chalicefy,709,1171,amsterdam","lee,69,857,barcelona","lee,99,940,bangkok","bob,206,1284,chicago","chalicefy,704,1269,chicago"]

        System.out.println(invalidTransactions(arr));

    }

    private static List<String> invalidTransactions(String[] transactions) {

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < transactions.length; i++){
            String [] strs = transactions[i].split(",");

            if(Integer.parseInt(strs[2]) > 1000 ){
                set.add(transactions[i]);
                continue;
            }

            for(int j = 0 ; j < transactions.length; j++){
                if(j == i)
                    continue;
                String [] arr = transactions[j].split(",");

                if(arr[0].equals(strs[0]) && Math.abs(Integer.parseInt(arr[1]) - Integer.parseInt(strs[1])) <= 60 && !arr[3].equals(strs[3])){
                    set.add(transactions[j]);
                    set.add(transactions[i]);
                    break;
                }
            }


        }

        return new ArrayList<String> (set);

    }
}
