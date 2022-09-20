package com.lemongo97.algorithm.list;

import java.util.Objects;

public class DoubleList<E> {

    public DoubleList<E> prev;

    public DoubleList<E> next;

    public E value;


    public DoubleList(DoubleList<E> prev, DoubleList<E> next, E value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public DoubleList(E value) {
        this.value = value;
    }

    public DoubleList() {
    }

    public static void main(String[] args) {
        DoubleList<Integer> doubleList = new DoubleList<>(1);

        doubleList.next = new DoubleList<>(2);
        doubleList.prev = null;

        doubleList.next.next = new DoubleList<>(3);
        doubleList.next.prev = doubleList;

        doubleList.next.next.next = new DoubleList<>(4);
        doubleList.next.next.prev = doubleList.next;

        doubleList.next.next.next.prev = doubleList.next.next;

        show(doubleList);
//        show(reverse(doubleList));
        show(deleteNode(doubleList, 11));
    }

    public static <E> void show(DoubleList<E> doubleList) {
        while (doubleList != null) {
            System.out.print("" + doubleList.value);
            doubleList = doubleList.next;
        }
        System.out.println();
    }

    public static <E> DoubleList<E> reverse(DoubleList<E> head) {
        DoubleList<E> prev = null;
        DoubleList<E> next = null;
        while (head != null) {
            next = head.next;

            head.next = prev;
            head.prev = next;

            prev = head;
            head = next;
        }
        return prev;
    }

    public static <E> DoubleList<E> deleteNode(DoubleList<E> head, E node) {
        while (head!=null){
            if (!Objects.equals(head.value,node)){
                break;
            }
            head = head.next;
            head.prev = null;
        }
        DoubleList<E> pre = head;
        DoubleList<E> cur = head;

        while (cur!=null){
            if (Objects.equals(cur.value, node)) {
                pre.next = cur.next;
                if (pre.next!=null){
                    pre.next.prev = pre;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


}
