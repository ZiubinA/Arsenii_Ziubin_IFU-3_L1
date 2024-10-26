package util;

public class LinkedListQueue<E> implements Queue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedListQueue(){

        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(E data) {
        Node<E> newNode = new Node<E>(data);
        if(isEmpty()){
            front = newNode;
        }else{
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public E dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");
        E item = front.data;
        front = front.next;
        size--;
        if(isEmpty()){
            rear = null;
        }
        return item;

    }

    public E peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return front.data;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int size(){
        return size;
    }
}
