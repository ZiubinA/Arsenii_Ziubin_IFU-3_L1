package util;



public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front;
    private int rear;
    private int size;
    private static final int capacity = 4;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.elements = (E[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(E e) {
        if (size == elements.length) {
            resize();
        }
        elements[rear] = e;
        rear = (rear + 1) % elements.length;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E item = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(front + i) % elements.length];
        }
        elements = newArray;
        front = 0;
        rear = size;
    }

    public E task2(int k){
        E max = elements[front];
        for(int i = 0; i <= k; i++){
            if(max.hashCode() < elements[front + i].hashCode()){
                max = elements[front + i];

            }
        }
        return max;
    }
}
