package com.ivan.study.algorithm.sort;

/**
 * Description:交换排序—冒泡排序
 * 思路：数组从第一个元素开始，相邻2元素进行比较，如果大小顺序不是需要的顺序，则交换两元素位置
 * author zhanglc
 * Created on 2018/1/10.
 */

public class BubbleSort {

    public static void sort(int[] arr) {
        //从第一个元素开始，知道倒数第二个元素
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) { //最大或最小都被放到最前和最后了，所以不用继续排序了
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = tmp ;
                }
            }
        }
    }
}