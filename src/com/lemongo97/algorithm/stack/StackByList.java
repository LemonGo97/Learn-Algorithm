package com.lemongo97.algorithm.stack;

import com.lemongo97.algorithm.list.DoubleList;

public class StackByList<E> {

    private DoubleList<E> head;
    private DoubleList<E> tail;

    public void push(E node) {
        if (head == null){
            head = new DoubleList<>(node);
            tail = head;
            return;
        }
        DoubleList<E> next = new DoubleList<>(node);
        next.prev = tail;
        tail.next = next;
        tail = next;
    }

    private E pop() {
        if (tail == null){
            throw new RuntimeException("没有可以推出的元素");
        }
        E value = tail.value;
        tail = tail.prev;
        if (tail != null){
            tail.next = null;
        }
        return value;
    }

    public static void main(String[] args) {
        StackByList<Integer> stack = new StackByList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

}
