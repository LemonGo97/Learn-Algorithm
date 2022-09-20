package com.lemongo97.algorithm.list;

import java.util.Objects;

public class SingleList<E> {
    public SingleList<E> next;
    public E value;


    public SingleList() {
    }

    public SingleList(E value) {
        this.value = value;
    }

    public SingleList(SingleList<E> next, E value) {
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SingleList{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {

        SingleList<String> list = new SingleList<>("1");
        list.next = new SingleList<>("2");
        list.next.next = new SingleList<>("3");
        list.next.next.next = new SingleList<>("4");
        list.next.next.next.next = new SingleList<>("5");

        System.out.println(list);
//        System.out.println(reverse(list));
        System.out.println(deleteNode(list, "3"));

    }

    public static <E> SingleList<E> reverse(SingleList<E> head) {

        SingleList<E> prev = null;
        SingleList<E> next = null;

        while (head != null) {

            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /**
     * 1. 先删除单链表前边与待删除数据相同的节点，保证下面流程处理时单链表头部一定不是待删除节点
     * 2. 设定两个指针都指向链表头节点
     * 3. pre 指针的作用是指向待删除节点的前一个节点，pre指针以及前面的数据均不删除节点
     * 4. cur 指针的作用是遍历所有节点
     * 5. 开始下一波循环
     * 6. 如果当前指针指向的值与待删除节点的值相同，那么 pre 指针指向的下一个节点为游标 cur 指针的下一个节点
     * 7. 如果当前指针指向的值与待删除的值不同，那么将 pre 指针与 cur 指针指向同一个位置
     * 8. 返回 head 指针
     * @param head
     * @param node
     * @param <E>
     * @return
     */
    public static <E> SingleList<E> deleteNode(SingleList<E> head, E node) {
        while (head != null) {
            if (!Objects.equals(head.value, node)) {
                break;
            }
            head = head.next;
        }

        SingleList<E> pre = head;
        SingleList<E> cur = head;
        while (cur != null){
            if (Objects.equals(cur.value, node)){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * 按照自己的理解写出来的，大概思路是head指针作为遍历的游标，prev作为最终返回的数据，依次将链表中每个节点打断并重组，cur 的作用是串联新的链表，next只是记录环境而已
     * @param head
     * @param node
     * @param <E>
     * @return
     */
    public static <E> SingleList<E> deleteNode2(SingleList<E> head, E node) {
        if (head == null) {
            return head;
        }
        SingleList<E> result = null;
        SingleList<E> next = null;
        SingleList<E> cur = null;
        while (head != null) {
            if (Objects.equals(head.value, node)) {
                head = head.next;
                continue;
            }
            next = head.next;
            head.next = null;
            if (result == null) {
                result = head;
                cur = result;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            head = next;
        }
        return result;
    }

}