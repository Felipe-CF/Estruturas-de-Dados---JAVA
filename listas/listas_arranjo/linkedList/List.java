package listas.listas_arranjo.linkedList;

public interface List<E> {
    public int size();
    public boolean isEmpty();
    public boolean isFirst();
    public boolean isLast();
    public void insertFirst(E e);
    public void insertLast(E e);
    public void insertBefore(E e, int ind);
    public void insertAfter(E e, int ind);
    public E remove(int ind);
} 
