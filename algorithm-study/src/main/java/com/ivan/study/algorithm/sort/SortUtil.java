package com.ivan.study.algorithm.sort;

/**
 * Description:
 * 排序：
 *      外排序：
 *      内排序：
 *          插入排序：
 *              直接插入：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置
 *                      （从后向前找到合适位置后），直到全部插入排序完为止。
 *              二分插入：
 *              希尔排序：
 *          选择排序：
 *              直接选择：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中
 *                      再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 *              堆排序：
 *          交换排序：
 *              冒泡排序：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
 *                        让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，
 *                        就将它们互换。
 *              快速排序：
 *          归并排序：
 *          基数排序：
 *
 * author zhanglc
 * Created on 2018/8/27.
 */

public class SortUtil {




    public static void main(String[] args) {
        int[] arg = {2, 8, 9, 3, 1, 4, 10, 0, 6, 5, 7};
//        int[] arg = {2};
//        selectSort(arg);
//        bubbleSort(arg);
//        insertSort(arg);
//        quickSort(arg , 0 , arg.length - 1);
//        directInsertSort(arg);

//        directInsertSort(arg);
//        bubbleSort(arg);
        selectSort(arg) ;
        pringArr(arg);


    }


    public static void directInsertSort(int[] arg) {
//        for (int i = 1 ; i < arg.length ; i++ ) {
//            int tmp = arg[i] , j ;
//            for (j = i ; j > 0 && arg[j - 1] > tmp ; j--) {
//                    arg[j] = arg[j -1] ;
//            }
//            arg[j] = tmp ;
//        }
        for (int i = 1 ; i < arg.length ; i++ ) {
            int tmp = arg[i] , j ;
            for (j = i ; j > 0 ; j--) {
                if (arg[j - 1] > tmp)
                    arg[j] = arg[j -1] ;
                else
                    break;
            }
            arg[j] = tmp ;
        }
    }


    public static void selectSort(int[] arg) {
        for (int i = 0 ; i < arg.length - 1 ; i++) {
            int flag = i  ;
            for (int j = flag + 1 ; j < arg.length ; j++) {
                if (arg[j] < arg[flag]) {
                    flag = j ;
                }
            }
            if (flag != i) {
                int tmp = arg[flag];
                arg[flag] = arg[i];
                arg[i] = tmp ;
            }
        }
    }


    public static void bubbleSort(int[] arg) {
        for (int i = 0 ; i < arg.length - 1 ; i++) {
            for (int j = 0 ; j < arg.length - i - 1 ; j++) {
                if (arg[j + 1] < arg[j]) {
                    int tmp = arg[j];
                    arg[j] = arg[j+1];
                    arg[j+1] = tmp ;
                }
            }
        }
    }




    public static void pringArr(int[] arg) {
        for (int i = 0; i < arg.length; i++)
            System.out.print(arg[i] + "   ");
        System.out.println();
    }
}
