package com.interview.剑指offer;

public class 三十六进制加法 {
    public static String add(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        int temp= Math.abs(len1-len2);
        
        if(len1>len2){
            str2=changeStr(str2,temp);
        }else if(len2>len1){
            str1=changeStr(str1,temp);
        }
        
        StringBuilder res = new StringBuilder();
        int plus=0,sum=0;
        for(int i=str1.length()-1;i>=0;i--){
            int num1=getNum(str1.charAt(i));
            int num2=getNum(str2.charAt(i));
            sum=num1+num2+plus;
            plus=0;
            String resStr;
            if(sum>35){
                plus=1;
                resStr = getStr(sum-36);
            }else{
                resStr = getStr(sum);
            }
            res.insert(0,resStr);
        }
        if(plus==1)
            res.insert(0,"1");

        return res.toString();
    }
    
    //对齐
    public static String changeStr(String str,int temp){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<temp;i++){
            stringBuilder.append("0");
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static int getNum(char c){
        if(c>='0'&&c<='9'){
            return c-'0';
        } else if(c>='A'&&c<'Z'){
            return c-'A'+10;
        }
        return 0;
    }

    public static String getStr(int num){
        if(num>=0 && num<=9){
            return String.valueOf(num);
        }
        else{
            int temp=num-10;
            char c = (char) ('A'+temp);
            return String.valueOf(c);
        }
    }

    private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String add_36(String a, String b) {
        int alength = a.length();
        int blength = b.length();
        int m = Math.max(alength, blength);
        int inc = 0;
        int clength = chars.length();
        String result = "";
        for (int i = 0; i < m; i++) {
            int ia = i < alength ? chars.indexOf(a.charAt(alength - i - 1)) : 0;
            int ib = i < blength ? chars.indexOf(b.charAt(blength - i - 1)) : 0;
            int add = ia + ib + inc;
            inc=0;
            if (add > clength) {
                inc = add / clength;
            }
            result = chars.charAt(add % clength) + result;
        }
        if (inc > 0) {
            result = chars.charAt(inc) + result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(add("MXY","PPPPPPPYP9"));
        System.out.println(add_36("MXY","PPPPPPPYP9"));
    }
}
