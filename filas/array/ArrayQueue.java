package array;

public class ArrayQueue<E> implements Queue<E> {
    private int capacity = 20;
    private E q[];
    private int size;
    protected int f;
    protected int n;
    public ArrayQueue(){
        f = -1;
        n = 0;
        q = (E[]) new Object[capacity];
    }
    public ArrayQueue(int cap){
        capacity = cap;
        q = (E[]) new Object[capacity];
    }

    public void enqueue(E e) {
           if(n == capacity-1)
            System.out.println("fila cheia!");
            else{
                if(isEmpty())
                    f++;
                q[n++] = e;
                size++;
            }
    }

    public E dequeue() throws EmptyQueueException{
        if(isEmpty())
            throw new EmptyQueueException("Queue is empty");
        E e = q[f++];

    }
    public E front();
    public int size();
    public boolean isEmpty();
    public String toString();
}
