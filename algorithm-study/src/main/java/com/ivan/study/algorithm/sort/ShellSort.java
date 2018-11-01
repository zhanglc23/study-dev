package com.ivan.study.algorithm.sort;

/**
 * Description: 插入排序—希尔排序（Shell`s Sort） 希尔排序又叫缩小增量排序
 * 基本思想：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * author zhanglc
 * Created on 2018/1/10.
 */

public class ShellSort {

    public static void sort(int[] arr) {
        int dk = arr.length/2 ;
        while (dk >= 1) {
            shellSort(arr , dk) ;
            dk /= 2 ;
        }

    }

    public static void shellSort(int[] arr , int dk) {
        for (int i = dk ; i < arr.length ; i++) {
            if(arr[i] > arr[i-dk]) {

            }

            int tmp = arr[i] ;
            int j ;
            for(j = i ; j > 0 && arr[j-1] > tmp; j--) { // 注意循环条件  arr[j-1] > tmp  必须得有
                arr[j] = arr[j -1] ;
            }
            arr[j] = tmp ;
        }
    }
}
