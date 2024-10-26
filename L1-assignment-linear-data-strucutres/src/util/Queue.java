package util;

public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E peek();

    public boolean isEmpty();
}
