package fila_fila;

import array.EmptyStackException;

public interface Stack<E> {
    public E top() throws EmptyStackException;
    public E pop() throws EmptyStackException;
    public void push(E e);
    public boolean isEmpty();
    public String toString();
}
