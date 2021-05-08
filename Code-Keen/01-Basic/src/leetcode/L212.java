package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName L212
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/28 17:21
 * @Version 1.0
 **/
public class L212 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    Set<String> set = new HashSet<>();

    //暴力方式：暴力查找
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0 || board == null || words == null) {
            return new ArrayList<>();
        }

        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        //插入words到Trie树种
        for (String word : words) {
            trie.insertWord(word);
        }

        boolean[][] isUsed = new boolean[m][n];
        //遍历查找
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie, isUsed);
            }
        }

        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int i, int j, Trie node, boolean[][] isUsed) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || isUsed[i][j]) {
            return;
        }

        char c = board[i][j];
        if (node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];
        if (node.isEnd) {
            set.add(node.val);
            node.isEnd = true;
            return;
        }

        for (int k = 0; k < 4; k++) {
            isUsed[i][j] = true;
            dfs(board, i + dx[k], j + dy[k], node, isUsed);
            isUsed[i][j] = false; //修正回原先状态
        }
    }

    class Trie {
        Trie[] children;
        boolean isEnd;
        String val;

        Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        void insertWord(String word) {
            int len = word.length();
            Trie node = this;
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index]; //往下移动一位
            }
            node.isEnd = true;
            node.val = word;
        }
    }


    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(new L212().findWords(board, words));

    }
}
