package com.ivan.study.algorithm.sort;

/**
 * Description: 交换排序—快速排序（Quick Sort）
 * 思路：
 * 1）选择一个基准元素,通常选择第一个元素或者最后一个元素,
 * 2）通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。
 * 3）此时基准元素在其排好序后的正确位置
 * 4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
 * author zhanglc
 * Created on 2018/1/10.
 */

public class QuickSort {

    public static void sort(int[] arr) {
        int i = 1 , j = arr.length - 1 , mid = arr[0];
        while( i < j ) {
            while (i < j && arr[j] > mid)
                j-- ;
            if(i < j) {
                arr[i] = arr[j] ;
                i++ ;
            }

            while (i < j && arr[i] < mid)
                i++ ;
            if(i < j) {
                arr[j] = arr[i] ;
                j-- ;
            }
        }
        arr[i] = mid ;
    }
}
