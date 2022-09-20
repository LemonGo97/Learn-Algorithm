package com.lemongo97.algorithm.queue;

import com.lemongo97.algorithm.list.DoubleList;

public class QueueByList<E> {

    private DoubleList<E> head;
    private DoubleList<E> tail;

    public void push(E node){
        if (head == null){
            head = new DoubleList<>(node);
            tail = head;
            return;
        }
        DoubleList<E> n = new DoubleList<>(node);
        n.prev = tail;
        tail.next = n;
        tail = n;
    }

    public E pop(){
        if (head == null){
            throw new RuntimeException("没有可以推出的元素");
        }
        E value = head.value;
        head = head.next;
        if (head != null){
            head.prev = null;
        }
        return value;
    }


    public static void main(String[] args) {
        QueueByList<Integer> queue = new QueueByList<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(3);
        queue.push(3);
        queue.push(3);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
