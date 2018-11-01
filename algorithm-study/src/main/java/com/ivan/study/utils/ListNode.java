package com.ivan.study.utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Description:
 * author zhanglc
 * Created on 2018/3/8.
 */

public class ListNode {

    protected int val ;

    protected ListNode next ;

    public ListNode(int val) {
        this.val = val ;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        Stack<Integer> stack = new Stack<Integer>() ;
        while (null != listNode) {
            stack.push(listNode.val);
            listNode = listNode.next ;
        }
        while(!stack.empty()) {
            list.add(stack.pop()) ;
        }
        return list ;
    }
}
