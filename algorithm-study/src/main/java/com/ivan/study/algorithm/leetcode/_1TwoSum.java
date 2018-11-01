package com.ivan.study.algorithm.leetcode;

import com.ivan.study.utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/8.
 */

public class _1TwoSum {


    public static int[] get(int[] args , int target) {
        Map<Integer , Integer> map = new HashMap<Integer , Integer>() ;
        int[] result = new int[2] ;
        for (int i = 0; i < args.length; i++) {
            if(map.containsKey(target - args[i])) {
                result[0] = map.get(target - args[i]) ;
                result[1] = i + 1 ;
            }
            map.put(args[i] , i+1) ;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arg = new int[]{1 ,3 ,5 , 7 , 8 ,2 , 9} ;
        PrintUtil.printArr(get(arg , 7));
    }


}
