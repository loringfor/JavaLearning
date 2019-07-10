package com.loring.leetcode;

import java.util.Arrays;

public class 全排列 {

    private static void core(int[] array) {
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                ArrayUtils.swap(array, cursor, i);
                System.out.println("A"+Arrays.toString(array));
                fullArray(array, cursor + 1, end);
                System.out.println("B"+Arrays.toString(array));
                ArrayUtils.swap(array, cursor, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        core(array);
    }
}

class ArrayUtils{
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
