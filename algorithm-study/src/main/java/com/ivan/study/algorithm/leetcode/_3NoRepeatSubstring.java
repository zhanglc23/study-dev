package com.ivan.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/9.
 */

public class _3NoRepeatSubstring {

    public static int get(String s ) {

        if(null == s || s.length() == 0)
            return  0 ;

        Map<Character , Integer> map = new HashMap<Character , Integer>() ;
        int left = 0 ;
        int max = 0 ;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i) ;
            left = Math.max(left , map.containsKey(c) ? map.get(c) : 0) ;
            max = Math.max(max , i - left + 1 ) ;
            map.put(c , i+1 ) ;
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "abcabcbb" ;
        System.out.println(get(a));
    }
}
