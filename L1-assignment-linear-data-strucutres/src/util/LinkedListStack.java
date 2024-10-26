package util;

public class LinkedListStack<E> implements Stack<E> {
    class Node {
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    public void push(E e) {
        Node newNode = new Node(e);
        newNode.next = top;
        top = newNode;

    }

    public E pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        E item = peek();
        top = top.next;
        return item;
    }

    public E peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
