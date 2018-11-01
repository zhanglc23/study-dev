package com.ivan.study.algorithm.leetcode;


/**
 * Description:
 * author zhanglc
 * Created on 2018/3/8.
 */

public class _2AddTwoNums {

    public static ListNode add(ListNode l1 , ListNode l2) {
        if(null == l1 && null != l2)
            return l2 ;

        if(null == l2 && null != l1)
            return l1 ;

        ListNode c1 = l1 ;
        ListNode c2 = l2 ;
        ListNode result = new ListNode(0) ;
        ListNode tmp = result ;
        int sum = 0 ;
        while (c1 != null || c2 != null ) {
            sum /= 10 ;
            if(c1 != null) {
                sum += c1.val ;
                c1 = c1.next ;
            }

            if(c2 != null) {
                sum += c2.val ;
                c2 = c2.next ;
            }

            tmp.next = new ListNode(sum % 10);

            tmp = tmp.next ;
        }

        if (sum / 10 == 1 )
            tmp.next = new ListNode(1);
        return result.next ;
    }

    public static void print(ListNode node) {
        if(null != node)
            System.out.print(node.val + "\t");

        while (node.next != null) {
            System.out.print(node.next.val + "\t");
            node = node.next ;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2) ;
        ListNode l12 = new ListNode(4) ;
        ListNode l13 = new ListNode(3) ;
        l11.next = l12 ;
        l12.next = l13 ;

        ListNode l21 = new ListNode(5) ;
        ListNode l22 = new ListNode(6) ;
        ListNode l23 = new ListNode(4) ;
        l21.next = l22 ;
        l22.next = l23 ;

        print(l11);
        print(l21);

        print(add(l11 , l21)) ;
    }


}

class ListNode {

    protected int val ;

    protected ListNode next ;

    public ListNode(int val) {
        this.val = val ;
    }
}
