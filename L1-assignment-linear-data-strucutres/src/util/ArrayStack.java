package util;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private static final int capacity = 10;
    private Object[] elements;
    private int size;

    public ArrayStack() {
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    public void push(E item) {
        if (size == elements.length) {
            resizeArray();
        }
        elements[size++] = item;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E item = peek();
        elements[--size] = null;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (E) elements[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
}
