package com.interview.顺丰科技;

        import java.util.*;

//00002:00130
//4 5 6
//AB:EF
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            String[] strs = str.split(":");
            String hour = strs[0];
            String minute = strs[1];
            int start = Math.max(getMin(hour),getMin(minute));
            List<Integer> res = new ArrayList<>();
            while(isHour(hour,start) && isMinute(minute,start)){
                res.add(start);
                start++;
            }
            if(res.size()<1){
                System.out.println(-1);
            }else{
                for (int i=0;i<res.size();i++){
                    System.out.print(res.get(i)+" ");
                }
                System.out.println();
            }
        }
    }

    public static int getMin(String str){
        int max=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int num=0;
            if(c>='0' && c<='9'){
                num = c-'0';
            }else if(c>='A' && c<='Z'){
                num = c-'A'+10;
            }
            max = Math.max(max,num);
        }
        return max+1;
    }

    public static boolean isHour(String hour,int start){
        int sum=0;
        int j=0;
        for(int i=hour.length()-1;i>=0;i--){
            char c = hour.charAt(i);
            int num=0;
            if(c>='0' && c<='9'){
                num = c-'0';
            }else if(c>='A' && c<='Z'){
                num = c-'A'+10;
            }
            sum+= num * Math.pow(start,j);
            j++;
        }
        if(sum<=24){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isMinute(String minute,int start){
        int sum=0;
        int j=0;
        for(int i=minute.length()-1;i>=0;i--){
            char c = minute.charAt(i);
            int num=0;
            if(c>='0' && c<='9'){
                num = c-'0';
            }else if(c>='A' && c<='Z'){
                num = c-'A'+10;
            }
            sum+= num * Math.pow(start,j);
            j++;
        }
        if(sum<=60){
            return true;
        }else {
            return false;
        }
    }
}
