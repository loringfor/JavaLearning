package com.interview.leetcode;

public class 寻找两个有序数组的中位数4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1>n2)
            return findMedianSortedArrays(nums2, nums1);
        int k = (n1 + n2 + 1)/2;
        int left = 0;
        int right = n1;
        while(left < right){
            int m1 = left+right >>1;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2-1])
                left = m1 + 1;
            else
                right = m1;
        }
        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
        if ((n1 + n2) % 2 == 1)
            return c1;
        int c2 = Math.min( m1 >= n1 ? Integer.MAX_VALUE :nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;

    }

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,4};
        int[] nums2 ={2,3,4,5,6,7};
//        double res = findMedianSortedArrays(nums1,nums2);
        double res = findMiddle(nums1,nums2);
        System.out.println(res);
    }

//    参考链接：https://blog.csdn.net/hk2291976/article/details/51107778
    public static double findMiddle(int[] nums1,int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1>len2){
            return findMiddle(nums2,nums1);
        }
        int L1=0,L2=0,R1=0,R2=0,cut1,cut2,low=0,high=2*len1;
        while (low<=high){
            cut1 = low+high >>1;
            cut2 = len1+len2-cut1;
            L1 = (cut1==0)?Integer.MIN_VALUE:nums1[(cut1-1)/2];
            R1 = (cut1==2*len1)?Integer.MAX_VALUE:nums1[cut1/2];
            L2 = (cut2==0)?Integer.MIN_VALUE:nums2[(cut2-1)/2];
            R2 = (cut2==2*len2)?Integer.MAX_VALUE:nums2[cut2/2];
            if(L1>R2){
                high = cut1-1;
            }else if(L2>R1){
                low = cut1+1;
            }else {
                break;
            }
        }
        return (Math.max(L1,L2)+Math.min(R1,R2))/2.0;
    }

}
