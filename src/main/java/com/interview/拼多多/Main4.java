package com.interview.拼多多;

import java.util.*;

public class Main4 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()){
                int n = in.nextInt();
                int m = in.nextInt();
                int k = in.nextInt();

                PriorityQueue<Integer> queue = new PriorityQueue<>(k);
                int count=0;
                int temp = (int)Math.sqrt(k);
                for(int i=n;i>=temp;i--){
                    for(int j=m;j>=temp;j--){
                        int num = i*j;
                        if(count<k){
                            queue.add(num);
                            count++;
                        }else{
                            if(num>queue.peek()){
                                queue.poll();
                                queue.add(num);
                            }
                        }
                    }
                }
                System.out.println(queue.peek());
        }
    }
}
