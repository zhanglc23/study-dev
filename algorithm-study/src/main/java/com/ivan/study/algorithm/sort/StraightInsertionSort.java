package com.ivan.study.algorithm.sort;

/**
 * Description:插入排序—直接插入排序(Straight Insertion Sort)
 * 基本思想:
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 * author zhanglc
 * Created on 2018/1/10.
 */

public class StraightInsertionSort {

    public static void sort(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++) {
            int tmp = arr[i] ;
            int j ;
            for(j = i ; j > 0 && arr[j-1] > tmp; j--) { // 注意循环条件  arr[j-1] > tmp  必须得有
                    arr[j] = arr[j -1] ;
            }
            arr[j] = tmp ;
        }
    }
}
