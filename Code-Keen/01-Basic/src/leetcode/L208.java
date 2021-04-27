package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName L208
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/26 19:09
 * @Version 1.0
 **/
public class L208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}


class Trie {

    Trie[] children;
    Boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        Integer len = word.length();

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int index = c-'a';
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }

        node.isEnd = true;
    }

    public Trie searchPrefix(String word) {
        //返回最终的那个node
        Trie node = this;
        Integer len = word.length();

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int index = c-'a';
            if(node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }
        }
        return node;
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return  node!= null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return  searchPrefix(prefix)!= null;
    }
}

class Trie1 {

    Map<Character, Trie1> children;
    char end_of_word;

    /** Initialize your data structure here. */
    public Trie1() {
        children = new HashMap();
        end_of_word = '#';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie1 node = this;
        for (char c: word.toCharArray()) {
            if(node.children.get(c) == null) {
                node.children.put(c,new Trie1());
            }
            node = node.children.get(c);
        }
        node.end_of_word = '@';

    }

    public Trie1 searchPrefix(String word) {
        Trie1 node = this;
        for (char c: word.toCharArray()) {
            if(node.children.get(c) == null) {
                return null;
            } else {
                node = node.children.get(c);
            }
        }
        return node;
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie1 node = searchPrefix(word);
        return  node!= null && node.end_of_word == '@';
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return  searchPrefix(prefix)!= null;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */