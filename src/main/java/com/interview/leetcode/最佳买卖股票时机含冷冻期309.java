package com.interview.leetcode;

public class 最佳买卖股票时机含冷冻期309 {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int n = prices.length;
        int[] hold = new int[n];
        int[] noHold = new int[n];
        if(n<2){
            return ret;// 不够一个周期，所以啥都没做；
        }else{
            hold[0] = -prices[0];
            hold[1] = Math.max(hold[0],-prices[1]);

            noHold[0] = 0;
            noHold[1] = Math.max(hold[0]+prices[1],0);

            for(int i = 2;i<n;i++){
                hold[i] = Math.max(noHold[i-2]-prices[i],hold[i-1]);
                noHold[i] = Math.max(hold[i-1]+prices[i],noHold[i-1]);
            }
        }
        return noHold[n-1];
    }
}
