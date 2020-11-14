package com.interview.bytedance;

import java.util.*;

public class Main {

    public static HashMap<String,Integer> hm = new HashMap<String,Integer>();

    static{
        hm.put("一", 1);
        hm.put("二", 2);
        hm.put("三", 3);
        hm.put("四", 4);
        hm.put("五", 5);
        hm.put("六", 6);
        hm.put("七", 7);
        hm.put("八", 8);
        hm.put("九", 9);
    }

    public static void main(String[] args) {
        String str = "五千三百零一万三千五百三十一";
//        System.out.println(getNum(str));
        System.out.println(Chinese2Int(str));
    }

    public static int getNum(String str){
        String chinaVal = "零一二三四五六七八九";
        String numVal = "十百千万";
        int[] num = {10,100,1000,10000};
        char[] strs = str.toCharArray();
        int len = strs.length;
        Stack<Integer> stack = new Stack();
        boolean flag = true;
        for(int i=0;i<len;i++){
            char c = strs[i];
            if(c == '零')continue;
            int chinaIndex = chinaVal.indexOf(c);
            int numIndex = numVal.indexOf(c);
            if(chinaIndex>-1){
                stack.push(chinaIndex);
            }else if(chinaIndex<0 && flag){
                stack.push(stack.pop()*num[numIndex]);
                flag = false;
            }else if(chinaIndex<0 && !flag){
                int tempSum=0;
                while(!stack.isEmpty()){
                    tempSum += stack.pop();
                }
                stack.push(tempSum*num[numIndex]);
                flag = true;
            }
        }
        System.out.println(stack.peek());
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    //汉字数字转化为整数
    public static int Chinese2Int(String num){

        List<Character> list = new ArrayList<Character>();
        String regex = "[一二三四五六七八九]";
        //最终返回的整数
        int finalnum = 0;
        //字符串长度
        int length = num.length();
        //幂，用来做幂运算
        int mi = length/2;

        char[] chars = num.toCharArray();

        //将千、百、十等表示位的汉字去掉，只留下具体数字，如三百二十一，只保留三、二、一，放入list
        for(char c : chars){
            if(String.valueOf(c).matches(regex))
                list.add(c);
        }

        for(Character c : list){
            //处理特殊情况--只有两位,eg:十八
            if(length == 2 && list.get(0) == '十'){
                finalnum += 10;
                mi--;
            }
            //处理正常情况
            if(mi >= 0){
                int wei = (int)Math.pow(10, mi);
                finalnum += hm.get(String.valueOf(c))*wei;
                mi --;
            }
        }
        return finalnum;
    }

}
































//public class Main {
//    public static int sqrtNum(int num){
//        int[] dp = new int[num+1];
//        for(int i=2; i<=num; i++){
//            //如果能开方
//            int sqrt = (int)Math.sqrt(i);
//            if(sqrt * sqrt == i){
//                dp[i] = dp[sqrt]+1;
//            }else{
//                dp[i]=dp[i-1]+1;
//            }
//        }
//        for(int i=0;i<dp.length;i++)
//            System.out.print(dp[i]+" ");
//        return dp[num];
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        System.out.println("输出为："+sqrtNum(num));
//
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(1,1);
//        map.put(2,2);
//        map.put(3,3);
//        map.put(4,4);
//        map.put(17,20);
//        Iterator<Map.Entry<Integer,Integer>> iterable = map.entrySet().iterator();
//        while (iterable.hasNext()){
//            Map.Entry<Integer,Integer> entry = iterable.next();
//            System.out.print("key: "+entry.getKey());
//            System.out.print(",value: "+entry.getValue());
//            System.out.println();
//        }
//
//    }
//}
