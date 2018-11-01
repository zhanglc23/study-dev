package com.ivan.study.algorithm.link;

/**
 * Description:
 * author zhanglc
 * Created on 2018/11/1.
 */

public class Test {

    public static void main(String[] args) {
        LinkList<String> list = initLink();

//        list.addFirst("header");
//        list.printLink();
//        list.delFirst();
//        LinkList.Node byIndex = list.findByIndex(5);
//        LinkList.Node byIndex = list.findByData("value=2");
//        System.out.println(byIndex.value);
//        list.addNode(2 , "test");
//        LinkList.Node node = list.delNode(2);
//        System.out.println(node.value);
        int length = list.length();
        System.out.println(length);
        list.printLink();


    }

    private static LinkList<String> initLink() {
        LinkList<String> list = new LinkList<String>(new LinkList.Node<String>("value=" + 0));
        LinkList.Node<String> tmp = list.getHead();
        for (int i = 1; i < 10; i++) {
            tmp.next = new LinkList.Node<String>("value=" + i);
            tmp = tmp.next;
        }
        return list;
    }


}
