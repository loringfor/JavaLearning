package com.interview.huawei;

import java.io.*;

public class 有效IP地址与掩码 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int a=0,b=0,c=0,d=0,e=0;
        int error=0,privateIp=0;
        String[] ip_mask;
        String[] ip;
        String[] mask;
        String str;
        int ipFirst;
        while ((str=in.readLine())!=null){
            ip_mask = str.split("~");
            ip = ip_mask[0].split("\\.");
            mask = ip_mask[1].split("\\.");
            if(checkMask(mask)){
                if(checkIp(ip)){
                    ipFirst = Integer.parseInt(ip[0]);
                    if(ipFirst>=1 && ipFirst<=126){
                        a++;
                        if(ipFirst==10)
                            privateIp++;
                    }else if(ipFirst>=128 && ipFirst<=191){
                        b++;
                        if(ipFirst==172 && Integer.parseInt(ip[1])>=16 && Integer.parseInt(ip[1])<=31)
                            privateIp++;
                    }else if(ipFirst>=192 && ipFirst<=223){
                        c++;
                        if(ipFirst==192 && Integer.parseInt(ip[1])==168)
                            privateIp++;
                    }else if(ipFirst>=224 && ipFirst<=239){
                        d++;
                    }else if(ipFirst>=240 && ipFirst<=255){
                        e++;
                    }
                }else {
                    error++;
                }
            }else {
                error++;
            }
        }
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+error+" "+privateIp);
    }

    // 检查掩码是否正确
    public static boolean checkMask(String[] mask){
        if("255".equals(mask[0])){
            if("255".equals(mask[1])){
                if("255".equals(mask[2])){
                    if("254".equals(mask[3]) || "252".equals(mask[3]) || "248".equals(mask[3]) ||
                            "240".equals(mask[3]) || "224".equals(mask[3]) || "192".equals(mask[3]) ||
                            "128".equals(mask[3]) || "0".equals(mask[3]))
                        return true;
                    else
                        return false;
                }else if("254".equals(mask[2]) || "252".equals(mask[2]) || "248".equals(mask[2]) ||
                        "240".equals(mask[2]) || "224".equals(mask[2]) || "192".equals(mask[2]) ||
                        "128".equals(mask[2]) || "0".equals(mask[2])){
                    if("0".equals(mask[3]))
                        return true;
                    else
                        return false;

                }else {
                    return false;
                }
            }else if("254".equals(mask[1]) || "252".equals(mask[1]) || "248".equals(mask[1]) ||
                    "240".equals(mask[1]) || "224".equals(mask[1]) || "192".equals(mask[1]) ||
                    "128".equals(mask[1]) || "0".equals(mask[1])){
                if("0".equals(mask[2]) && "0".equals(mask[3]))
                    return true;
                else
                    return false;

            }else {
                return false;
            }
        }
        else if("254".equals(mask[0]) || "252".equals(mask[0]) || "248".equals(mask[0]) ||
                "240".equals(mask[0]) || "224".equals(mask[0]) || "192".equals(mask[0]) ||
                "128".equals(mask[0])){
            if("0".equals(mask[1]) && "0".equals(mask[2]) && "0".equals(mask[3]))
                return true;
            else
                return false;

        }else {
            return false;
        }
    }

    public static boolean checkIp(String[] ip){
        if(ip.length!=4 || "".equals(ip[0]) || "".equals(ip[1]) || "".equals(ip[2]) || "".equals(ip[3]))
            return false;
        else
            return true;
    }
}
