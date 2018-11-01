package com.ivan.study.algorithm.array;

import com.ivan.study.utils.PrintUtil;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/19.
 */

public class ArraySort {

//    public static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i -1 ; j++) {
//                if(arr[j] > arr[j+1]) {
//                    int tmp = arr[j+1] ;
//                    arr[j+1] = arr[j] ;
//                    arr[j] = tmp ;
//                }
//            }
//        }
//    }

//    public static void selectSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int base = arr[i] , k = i ;
//            for (int j = k + 1 ; j < arr.length ; j++) {
//                if(arr[j] < arr[k]) {
//                    k = j ;
//                }
//            }
//            if(k != i ) {
//                arr[i] =  arr[k] ;
//                arr[k] = base ;
//            }
//        }
//    }
    
    
//    public static void insertSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int cur = arr[i] , j ;
//            for ( j = i; j > 0 && cur < arr[j - 1]; j--) {
//                arr[j] = arr[j -1] ;
//            }
//            arr[j] = cur ;
//        }
//    }

//    public static void quickSort(int[] arr , int start , int end) {
//        if(start < end) {
//            int base = arr[start] ;
//            int i = start , j = end , tmp ;
//            while (i <= j) {
//                while (i < end && arr[i] < base) {
//                    i++ ;
//                }
//                while (start < j && arr[j] > base) {
//                    j-- ;
//                }
//                if(i <= j) {
//                    tmp = arr[i] ;
//                    arr[i] = arr[j] ;
//                    arr[j] = tmp ;
//                    j-- ;
//                    i++ ;
//                }
//            }
//            if(start < j)
//                quickSort(arr ,start ,j);
//            if(i < end)
//                quickSort(arr ,i ,end);
//        }
//
//    }




    public static void main(String[] args) {
//        int[] arr = new int[]{7 ,4,1,0,2,5,8,9,6,3,32,25,45,29,99} ;
//        PrintUtil.printArr(arr);
////        bubbleSort(arr);
////        selectSort(arr) ;
////        insertSort(arr) ;
//        quickSort(arr , 0 , arr.length -1);
//        PrintUtil.printArr(arr);
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        call(a , b );
        System.out.println(a + "," + b);
    }

    public static void call(StringBuffer x , StringBuffer y) {
        x.append(y) ;
        y = x ;
    }


}
