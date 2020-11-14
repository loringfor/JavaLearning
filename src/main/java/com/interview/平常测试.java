package com.interview;

public class 平常测试 {

    public static String longestPalindrome(String s) {
        if(s==null || s.length()<1)
            return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1 = reverse(s,i,i);
            int len2 = reverse(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end-start+1){
                start = i -(len-1)/2;
                end = i+len/2;
            }
        }
        System.out.println(start+" "+end);
        return s.substring(start,end+1);
    }

    public static int reverse(String s,int left,int right){
        while(left>=0 && left<s.length() && right>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public static int GetUglyNumber_Solution(int index) {
        if(index<1)
            return 0;
        int[] res = new int[index];
        res[0]=1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<index;i++){
            int min = Math.min(res[i2]*2,Math.min(res[i3]*3,res[i5]*5));
            if(min==res[i2]*2){
                i2++;
            }
            if(min==res[i3]*3){
                i3++;
            }
            if(min==res[i5]*5){
                i5++;
            }
            res[i]=min;
        }
        return res[index-1];
    }
    public static void main(String[] args){
        String s = "babad";
        System.out.println(GetUglyNumber_Solution(7));
//        System.out.println(res);
    }
}
