package com.interview.百度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    static class Node{
        int val;
        ArrayList<Node> next;
        Node(int val){
            this.val =val;
            this.next = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            Node[] nodes = new Node[n+1];
            for(int i=1;i<=n;i++){
                nodes[i] = new Node(i);
            }
            for(int i=0;i<n-1;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                nodes[a].next.add(nodes[b]);
                nodes[b].next.add(nodes[a]);
            }
            LinkedList<Node> queue = new LinkedList<>();
            for(int i=1;i<=n;i++){
                if(nodes[i].next.size()==1){
                    queue.add(nodes[i]);
                }
            }
            int[] nums = new int[n+1];
            int count=1;
            int all = queue.size();
            while ((!queue.isEmpty())){
                int i=1;
                int temall=0;
                while (i<=all){
                    Node node = queue.poll();
                    nums[node.val]=count;
                    for(Node temp:node.next){
                        temp.next.remove(node);
                        if(temp.next.size()==1){
                            queue.add(temp);
                            temall++;
                        }
                    }
                    i++;
                }
                count++;
                all=temall;
            }
            for(int i=1;i<=n;i++){
                System.out.print(nums[i]+" ");
            }
            System.out.println();
        }
    }
}
