package listas.listas_arranjo.array;

public class ArrayIndexList<E> implements IndexList<E> {
    private E[] a;
    private	 int capacity;
    private int size;
    public ArrayIndexList(){
        capacity = 8;
        size = 0;
        a = (E[]) new Object[capacity];
    }
}
