package dsatutorial.datastructures.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(); // root is empty
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26]; // storing english words, a --> z
            this.isWord = false;
        }
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input. ");
        }
        word = word.toLowerCase(); // we will be dealing only with lower case words
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input. ");
        }
        word = word.toLowerCase(); // we will be dealing only with lower case words
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return current.isWord;
    }

    public static void main(String[] args) {
        String word1 = "cat";
        String word2 = "son";
        String word3 = "cab";
        String word4 = "so";
        Trie trie = new Trie();
        trie.insert(word1);
        trie.insert(word2);
        trie.insert(word3);
        trie.insert(word4);
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("car"));
    }
}
