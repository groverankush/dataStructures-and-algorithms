package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/05/20
 */
public class P151ImplementTrie {

    public static void main(String[] args) {

        Trie t = null;


        String[] commands = {"Trie", "insert", "insert", "insert", "insert", "insert", "insert", "search", "search", "search", "search", "search", "search", "search", "search", "search", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith"};
        String[] arguments = {"", "app", "apple", "beer", "add", "jam", "rental", "apps", "app", "ad", "applepie", "rest", "jan", "rent", "beer", "jam", "apps", "app", "ad", "applepie", "rest", "jan", "rent", "beer", "jam"};

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "Trie":
                    t = new Trie();
                    break;
                case "insert":
                    t.insert(arguments[i]);
                    break;
                case "search":
                    t.search(arguments[i]);
                    break;
                case "startsWith":
                    t.startsWith(arguments[i]);
                    break;
            }
        }
    }


    static class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.arr[index] == null)
                    node.arr[index] = new TrieNode();
                node = node.arr[index];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.arr[index] == null)
                    return false;
                node = node.arr[index];
            }

            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (node.arr[index] == null)
                    return false;
                node = node.arr[index];
            }

            return true;
        }

        class TrieNode {
            TrieNode[] arr = new TrieNode[26];
            boolean isEnd = false;

            TrieNode() {

            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
