package com.ivan.study.algorithm.link;

/**
 * Description:
 * author zhanglc
 * Created on 2018/11/1.
 */

public class LinkList<T> {

    private Node<T> head ;

    public LinkList(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * 长度
     * @return
     */
    public int length() {
        Node tmp = head ;
        int length = 0 ;
        while (tmp != null) {
            length++ ;
            tmp = tmp.next;
        }
        return length ;
    }

    /**
     * 插入元素
     * @param index
     * @param value
     */
    public void addNode(int index , T value) {
        int pos = 0 ;
        Node cur = head ;
        Node pre = head ;
        Node node = new Node(value) ;
        while (cur != null ) {
            if (pos == index) {
                node.next = cur;
                pre.next = node;
                return;
            }
            pre = cur ;
            cur = cur.next ;
            pos++ ;
        }
    }

    /**
     * 删除指定位置数据
     * @param index
     * @return
     */
    public Node delNode(int index) {
        int pos = 0 ;
        Node cur = head ;
        Node pre = head ;
        while (cur != null) {
            if (pos == index) {
                Node tmp = cur ;
                pre.next = cur.next;
                return tmp ;
            }
            pre = cur ;
            cur = cur.next;
            pos++ ;
        }
        return null;
    }

    /**
     * 查询指定位置元素
     * @param index
     * @return
     */
    public Node findByIndex(int index ) {
        int pos = 0 ;
        Node tmp = head ;
        while (tmp != null) {
            pos++ ;
            if (pos == index) {
                return tmp ;
            }
            tmp = tmp.next ;
        }
        return null ;
    }

    /**
     * 查询指定数据节点
     * @param data
     * @return
     */
    public Node findByData(T data) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(data)) {
                return current ;
            }
            current = current.next ;
        }
        return null;
    }

    /**
     * 删除头结点并返回
     * @return
     */
    public Node delFirst() {
        Node tmp = null ;
        if (head == null) {
            System.out.println("头结点不存在");
        }else {
            tmp = head ;
            head = head.next ;
        }
        return tmp ;
    }


    /**
     * 添加头结点
     * @param data
     */
    public void addFirst(T data) {
        if (null == this.head) {
            head = new Node<T>(data) ;
        }else {
            Node tmp = head ;
            head = new Node<T>(data) ;
            head.next = tmp ;
        }
    }

    /**
     * 打印
     */
    public void printLink() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();
    }




    static class Node<T> {
        T value ;

        Node<T> next ;

        public Node(T value) {
            this.value = value;
        }
    }

}
