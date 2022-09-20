package com.lemongo97.algorithm.queue;

public class QueueByArray<E> {
    private E[] values = (E[]) new Object[4];
    // 队尾指针指向下一个无数据的位置
    private int tailPosition = 0;

    // 队首指针指向第一个有数据的位置
    private int headPosition = 0;

    // 队列现在的长度
    private int size = 0;

    public void push(E value) {
        if (size == values.length) {
            throw new RuntimeException("full");
        }
        if (size < values.length && tailPosition == values.length) {
            // 数组中有剩余空间，但队列尾指针已经到了数组最后，队列首指针不在数组头部
            tailPosition = 0;
        }
        values[tailPosition] = value;
        tailPosition++;
        size++;
    }

    public E pop() {
        if(size == 0){
            return null;
        }
        if (headPosition == values.length - 1 && size < values.length){
            headPosition = 0;
            size --;
            return values[values.length - 1];
        }

        headPosition++;
        size --;
        return values[headPosition - 1];
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        QueueByArray<Integer> queue = new QueueByArray<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println();
    }

}