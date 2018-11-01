package com.ivan.study;


import java.util.Stack;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/15.
 */

public class Test {

    public static boolean getTarget(int target, int[][] array) {
//        if(array.length != 0 && array[0].length != 0) {
//            int len = array.length - 1  ;
//            for (int i = len; i >= 0; i--) {
//                if(array[i][0] < target) {
//                    for (int j = 1; j < array[0].length; j++) {
//                        if(array[i][j] == target) {
//                            return true ;
//                        }
//                    }
//                }else if(array[i][0] == target) {
//                    return true ;
//                }
//            }
//        }
//        return false ;
        int len = array.length - 1  ;
        int j = 0 ;
        while (j < array[len].length && len >= 0) {
            if(array[len][j] > target) {
                len-- ;
            }else if(array[len][j] < target) {
                j++ ;
            }else {
                return true ;
            }
        }
        return false ;
    }

    public static String main(StringBuffer str) {
        StringBuffer sb = new StringBuffer() ;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                sb.append("%20") ;
            }else {
                sb.append(str.charAt(i)) ;
            }
        }
        return sb.toString() ;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node) ;
    }
    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop()) ;
        }

        int top = stack2.pop() ;
        while (!stack2.empty()) {
            stack1.push(stack2.pop()) ;
        }
        return top ;
    }


//    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。


    public int Fibonacci(int n) {
        if(n <= 0) {
            return 0 ;
        }
        if(n == 1 || n == 2) {
            return 1 ;
        }
        int a = 1 ,b = 1 , i = 3 ;int c = 0 ;
        while (i <= n) {
            c = a + b ;
            a = b ;
            b = c ;
            i++ ;
        }
        return  c ;
    }





    // n = 0 , 1
    // n= 1 ,  1
    // n = 2 , 2
    //n=3 , 3
    //n=4   , 5

}
