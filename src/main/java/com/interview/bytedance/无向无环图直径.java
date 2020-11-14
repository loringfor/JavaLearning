package com.interview.bytedance;

import java.util.*;

public class 无向无环图直径 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> nodeLinkMap = new HashMap();
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            for (int j = 0; j < m - 1; j++) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                List<Integer> list = nodeLinkMap.get(n1);
                if (list == null) {
                    list = new ArrayList<Integer>();
                    nodeLinkMap.put(n1, list);
                }
                list.add(n2);

                List<Integer> list2 = nodeLinkMap.get(n2);
                if (list2 == null) {
                    list2 = new ArrayList<Integer>();
                    nodeLinkMap.put(n2, list2);
                }
                list2.add(n1);
            }
            int maxLink = 0;// store the result

//            List<Integer> curMaxLinkNodes;
//            for (int k = 1; k <= m; k++) {
//                curMaxLinkNodes = new ArrayList<Integer>();
//                curMaxLinkNodes.add(k);
//                List<Integer> linkNodes = new ArrayList<Integer>();
//                linkNodes.add(k);
//                curMaxLinkNodes = processMaxLink(nodeLinkMap, k, linkNodes, curMaxLinkNodes);
//                if (curMaxLinkNodes.size() - 1 > maxLink) {
//                    maxLink = curMaxLinkNodes.size() - 1;
//                }
//            }

            List<Integer> curMaxLinkNodes = new ArrayList();
            curMaxLinkNodes.add(1);
            List<Integer> linkNodes = new ArrayList<>();
            linkNodes.add(0);
            curMaxLinkNodes = processMaxLink(nodeLinkMap,1,linkNodes,curMaxLinkNodes);
            Integer end = curMaxLinkNodes.get(curMaxLinkNodes.size()-1);
            curMaxLinkNodes.clear();
            linkNodes.clear();
            curMaxLinkNodes.add(end);
            linkNodes.add(end);
            curMaxLinkNodes = processMaxLink(nodeLinkMap,end,linkNodes,curMaxLinkNodes);

            maxLink = curMaxLinkNodes.size()-1;
            System.out.println(maxLink);
        }
    }

    private static List<Integer> processMaxLink(Map<Integer, List<Integer>> nodeLinkMap, Integer k, List<Integer> linkNodes, List<Integer> maxLinkNodes) {
        List<Integer> list = nodeLinkMap.get(k);
        if (list == null || list.size() == 0 || linkNodes.containsAll(list)) {
            return linkNodes;
        }
        for (Integer node : list) {
            if (linkNodes.contains(node)) {
                continue;
            }
            List<Integer> tmpLinkNodes = new ArrayList<Integer>(linkNodes);
            tmpLinkNodes.add(node);
            tmpLinkNodes = processMaxLink(nodeLinkMap, node, tmpLinkNodes, maxLinkNodes);
            if (tmpLinkNodes.size() > maxLinkNodes.size()) {
                maxLinkNodes = tmpLinkNodes;
            }
        }
        return maxLinkNodes;
    }
}
