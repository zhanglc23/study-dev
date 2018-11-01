package com.ivan.study.algorithm.leetcode.array;

/**
 * Description:
 * author zhanglc
 * Created on 2018/1/12.
 */

public class RemoveDuplicatesFromSortedArray {

    public static int operate(int[] arr ) {
        int i = 0 ,j = 0 ;
        for (; i < arr.length -1 ; i++) {
            if(arr[i] == arr[i+1]) {
                arr[j] = arr[i] ;
            }else
                j++ ;
                continue;
        }
        return j ;
    }
}
