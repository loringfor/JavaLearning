package com.interview.拼多多;

import java.util.*;

//产品经理小梅喜欢和他的男朋友小白一块玩扑克游戏。每一局，小梅抽取N张扑克牌，自左向右依次排列在桌面上；小白也抽取M（8>=N>=M>=1）张扑克牌，自左向右依次排列在桌面上。
//小梅需要进行N个回合，使用手中的扑克牌，组成一个新的扑克牌的序列每个回合，小梅有d、l、r三种策略
//选择d时，小梅将最左边的扑克牌丢弃
//选择l时，小梅将最左边的扑克牌取出，放到新的扑克牌序列的最左边
//选择r时，小梅将最左边的扑克牌取出，放到的扑克牌序列的最右边
//N个回合完成，新的扑克牌序列与小白的扑克牌完全样（只考虑数字，不考虑花色），则小梅胜出
//小梅向程序员小岛提了一个需求，希望了解获胜的全部方法。简化起见扑克牌仅包合1-9。
public class Main2 {

    static List<String> res;
    static ArrayDeque<String> road;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int S = in.nextInt();
            for (int i = 0; i < S; i++) {
                String nums1 = in.next();
                String nums2 = in.next();
                res = new ArrayList<>();
                road = new ArrayDeque<>();
                find(nums1, "", nums2);
                printResult(res);
            }
        }
    }

    private static void find(String origin, String now, String target) {
        if (target.equals(now)) {
            if (origin.length() >= 0) {
                for (int i = 0; i < origin.length(); i++) {
                    road.offer("d");
                }
            }
            res.add(String.join(" ",road));
            return;
        }
        if (origin == null || origin.length() == 0) {
            return;
        }

        String left = String.valueOf(origin.charAt(0));
        String norigin = origin.substring(1);

        road.offer("d");
        find(norigin, now, target);
        road.pollLast();

        road.offer("l");
        find(norigin, left + now, target);
        road.pollLast();

        road.offer("r");
        find(norigin, now + left, target);
        road.pollLast();
    }

    private static void printResult(List<String> res) {
        System.out.println("{");
        if (res == null || res.size() == 0) {
            System.out.println("}");
            return;
        } else {
            Collections.sort(res, (o1, o2) -> o1.compareTo(o2));
            for (int i = 0; i < res.size(); i++) {
                String s = res.get(i);
                System.out.println(String.join(" ", s));
            }
        }
        System.out.println("}");
    }
}
