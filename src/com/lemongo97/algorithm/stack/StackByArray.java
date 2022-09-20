package com.lemongo97.algorithm.stack;

import java.util.Arrays;

public class StackByArray<E> {
    private E[] values = (E[]) new Object[16];
    private int pos = 0;
    private int size = 0;

    public void push(E value) {
        if (size == values.length){
            E[] values = (E[]) new Object[this.values.length * 2];
            for (int i = 0; i < this.values.length; i++) {
                values[i] = this.values[i];
            }
            this.values = values;
        }
        this.values[pos] = value;
        pos++;
        size++;
    }

    public E pop() {
        if (size == 0){
            return null;
        }
        size--;
        pos--;
        return values[pos];
    }

    public int size(){
        return this.size;
    }


    @Override
    public String toString() {
        return "StackByArray{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    public static void main(String[] args) {
        StackByArray<Integer> stack = new StackByArray<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        System.out.println("size: " + stack.size);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size: " + stack.size);
        System.out.println(stack);

    }
}