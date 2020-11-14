package com.interview.huawei;

import java.util.Scanner;

public class 前缀树 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            //15
            int len = in.nextInt();
            //115 112 116 97 111 121 114 101 105 112 121 114 102 115 116
            int[] labels = new int[len];
            //0 0 0 1 1 0 1 0 0 0 0 1 1 1 1
            int[] hasChild = new int[len];
            //1 1 0 1 0 1 1 1 0 0 0 1 1 0 0
            int[] pouds = new int[len];
            for(int i=0;i<len;i++){
                labels[i]=in.nextInt();
            }
            for(int i=0;i<len;i++){
                hasChild[i]=in.nextInt();
            }
            for(int i=0;i<len;i++){
                pouds[i]=in.nextInt();
            }
            // 8
            int N = in.nextInt();
            //1 2 3 4 5 6 7 8
            int[] values = new int[N];
            for(int i=0;i<N;i++){
                values[i]=in.nextInt();
            }
            //3
            int P = in.nextInt();
            //116 114 112
            int[] key = new int[N];
            for(int i=0;i<P;i++){
                key[i]=in.nextInt();
            }


        }
    }
}


class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(int[] nums) {
        TrieNode node = root;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!node.containsKey(temp)) {
                node.put(temp, new TrieNode());
            }
            node = node.get(temp);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(int[] nums) {
        TrieNode node = root;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (node.containsKey(temp)) {
                node = node.get(temp);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(int[] nums) {
        TrieNode node = searchPrefix(nums);
        return node != null && node.isEnd();
    }
}

class TrieNode {

    private TrieNode[] links;

    private final int R = 256;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(int num) {
        return links[num] != null;
    }
    public TrieNode get(int num) {
        return links[num];
    }
    public void put(int num, TrieNode node) {
        links[num] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
