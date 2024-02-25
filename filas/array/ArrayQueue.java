package array;

public class ArrayQueue<E> implements Queue<E> {
    private int capacity = 8;
    private E q[];
    private int size;
    protected int first;
    protected int next;
    public ArrayQueue(){
        q = (E[]) new Object[capacity];
    }
    public ArrayQueue(int cap){
        capacity = cap;
        q = (E[]) new Object[capacity];
    }
    public E first() throws EmptyQueueException{
        if(isEmpty())
            throw new EmptyQueueException("Fila vazia");
        return q[first];
    }
    public int size(){
        return (capacity - first + next) % capacity;
    }
    public boolean isEmpty(){
        return first == next;
    }
    public String toString(){
        String s = "[";
        for(int i = 0; i < capacity; i++ ){
            if(q[i] == null)
                s += " ";
            else
                s += q[i];
            if(i != capacity-1)
                s+= ", ";
        }
        return s+"]";
    }
    
    public void enqueue(E e) {
           if(size() == capacity-1)
            System.out.println("fila cheia!");
            else {
                q[next] = e;
                next = (next+1) % capacity;
            }
    }

    public E dequeue() throws EmptyQueueException{
        if(isEmpty())
            throw new EmptyQueueException("Queue is empty");
        E e = q[first];
        q[first] = null;
        first = (++first) % capacity;
        return e;
    }
    
}
