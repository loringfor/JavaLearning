package com.loring.sort;

public class Solution {
    int[] count=new int[256];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        count[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ch='#';
        for(int i=0;i<256;i++){
            if(count[i]==1)
                ch=(char)i;
        }
        return ch;
    }
}
