package com.ivan.study.algorithm.sort;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/9.
 */

public class ArraySort1 {
    /**
     *  从第一个元素开始，该元素可以认为已经被排序
     *  取出下一个元素，在已经排序的元素序列中从后向前扫描
     *  如果该元素（已排序）大于新元素，将该元素移到下一位置
     *  重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *  将新元素插入到该位置中
     *  重复步骤2
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i] , j;
            for (j = i; j > 0 && tmp < arr[j - 1 ]; j--) {
                arr[j] = arr[j - 1 ] ;
            }
            arr[j] = tmp ;
        }
    }
    /**
     *  冒泡法排序
     *  比较相邻的元素。如果第一个比第二个小，就交换他们两个。
     *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
     *  针对所有的元素重复以上的步骤，除了最后一个。
     *  持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param arr 需要排序的整型数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1 ] ;
                    arr[j + 1] = arr[j] ;
                    arr[j] = tmp ;
                }
            }
        }
    }
    /**
     * 快速排序
     *  从数列中挑出一个元素，称为“基准”
     *  重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     *  在这个分割之后，
     *  该基准是它的最后位置。这个称为分割（partition）操作。
     *  递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr , int start, int end) {
        if (start < end) {
            int base = arr[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            while (i <= j) {
                while (arr[i] < base && i < end)
                    i++;
                while (arr[j] > base && j > start)
                    j--;
                if (i <= j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }
            if (start < j)
                quickSort(arr, start, j);
            if (end > i)
                quickSort(arr, i, end);
        }
    }
    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int flag = i;
            for (int j = flag + 1 ; j < arr.length ; j++) {
                if(arr[flag] > arr[j] ) {
                    flag = j ;
                }
            }
            if(flag != i) {
                int tmp = arr[i] ;
                arr[i] = arr[flag] ;
                arr[flag] = tmp ;
            }
        }
    }
    /**
     * 归并排序
     *  申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     *  设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *  比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     *  重复步骤3直到某一指针达到序列尾
     *  将另一序列剩下的所有元素直接复制到合并序列尾
     * @param arr
     */
    public static void mergeSort(int[] arr , int left, int right) {
        int t = 1;// 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;// 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge(arr, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                merge(arr, i, i + (s - 1), right);
        }
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    /**
     * 归并算法实现
     * @param data
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];

        for (int i = p; i <= r; i++)
            data[i] = B[i];
    }
    public static void main(String[] args) {
        int[] a = {7 ,4,1,0,2,5,8,9,6,3,32,25,45,29,99} ;
//        selectSort(a);
//        quickSort(a , 0 ,a.length -1 );
        mergeSort(a , 0 , a.length  );
        printArr(a);
    }


    public static void quick(int[] arr , int left , int right) {
        int start = left ;
        int end = right ;
        int stander = arr[left] ;
        while (start < end) {
            while (end > start && arr[end] >= stander) {
                end-- ;
            }
            if(arr[end] <= stander) {
                int tmp = arr[end] ;
                arr[end] = arr[start] ;
                arr[start] = tmp ;
            }

            while(end>start&&arr[start]<=stander) {
                start++;
            }
            if (arr[start] >= stander) {
                int tmp = arr[start] ;
                arr[start] = arr[end];
                arr[end] = tmp ;
            }
        }

        if (start > left)
            quick(arr , left , start - 1 );
        if (end < right)
            quick(arr , end + 1 , right);
    }


}
