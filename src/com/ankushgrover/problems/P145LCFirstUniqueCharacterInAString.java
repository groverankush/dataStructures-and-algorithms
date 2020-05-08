package com.ankushgrover.problems;


import java.util.LinkedHashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 05/05/20
 */
public class P145LCFirstUniqueCharacterInAString {

    public static void main(String[] args) {
        P145LCFirstUniqueCharacterInAString obj = new P145LCFirstUniqueCharacterInAString();
        System.out.println(obj.firstUniqChar(""));
    }


    class Pair{
        int count;
        int index;

        public Pair(int count, int index) {
            this.count = count;
            this.index = index;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public int firstUniqChar(String s) {

        LinkedHashMap<Character, Pair>map = new LinkedHashMap<>();

        for(int i = 0 ; i < s.length(); i++){

            Pair pair = map.getOrDefault(s.charAt(i), new Pair(0,0));
            pair.setCount(pair.getCount() + 1);
            pair.setIndex(i);

            map.put(s.charAt(i), pair);

        }

        for(Character ch : map.keySet()){
            Pair pair = map.get(ch);
            if(pair.getCount() == 1)
                return pair.getIndex();
        }

        return -1;

        /*int arr[][] = new int[2][26];

        for(int i = 0 ; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            ++arr[0][index];
            arr[1][index] = i;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(arr[0][i] == 1){
                return arr[1][i];
            }
        }
        return -1;*/
    }
}
