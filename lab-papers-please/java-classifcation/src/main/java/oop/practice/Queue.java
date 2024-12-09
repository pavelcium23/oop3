package oop.practice;
public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    int size();

    boolean isEmpty();

}