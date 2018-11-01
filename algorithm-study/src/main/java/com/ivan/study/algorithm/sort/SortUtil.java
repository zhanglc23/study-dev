package com.ivan.study.algorithm.sort;

/**
 * Description:
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
        quickSort(arg , 0 , arg.length - 1);
        pringArr(arg);


    }

    public static void quickSort(int[] arg , int start , int end) {
        if(start < end) {
            int stand = arg[start] ;
            int i = start , j = end ;
            while (i <= j ) {
                while (arg[i] < stand && i < end)
                    i++;
                while (arg[j] > stand && j > start)
                    j-- ;
                if(i <= j) {
                    int tmp = arg[i] ;
                    arg[i] = arg[j] ;
                    arg[j] = tmp ;
                    i++ ;
                    j-- ;
                }
            }
            if (start < j)
                quickSort(arg, start, j);
            if (i < end)
                quickSort(arg, i, end);
        }
    }

    public static void insertSort(int[] arg) {
        for (int i = 1 ; i < arg.length ; i++ ) {
            int tmp = arg[i] , j ;
            for (j = i ; j > 0 && arg[j - 1 ] > tmp ; j-- ) {
                    arg[j] = arg[j - 1 ] ;
            }
            arg[j] = tmp ;
        }
    }

    public static void bubbleSort(int[] arg) {
        if (arg.length < 2)
            return;
        for (int i = 0 ; i < arg.length - 1 ; i++) {
            for (int j = arg.length - 1 ; j > i; j-- ) {
                if(arg[i] > arg[j]) {
                    int tmp = arg[i] ;
                    arg[i] = arg[j];
                    arg[j] = tmp ;
                }
            }
        }
    }


    public static void selectSort(int[] arg) {
        if (arg.length < 2)
            return;
        int tmp;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                tmp = arg[i];
                if (tmp > arg[j]) {
                    arg[i] = arg[j];
                    arg[j] = tmp;
                }
            }
        }
    }

    public static void pringArr(int[] arg) {
        for (int i = 0; i < arg.length; i++)
            System.out.print(arg[i] + "   ");
    }
}
