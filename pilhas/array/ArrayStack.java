package array;

public class ArrayStack<E> implements stack<E> {
    protected int cap = 8;
    protected E[] a;
    protected int top;
    protected int size;
    public ArrayStack(){    top = -1;   size = 0;   a = (E[]) new Object[cap];}
    public ArrayStack(int c){   cap = c;   top = -1;   size = 0;   a = (E[]) new Object[cap];}
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}

    public void push(E e){
        if(size != cap){
            a[++top] = e;
            ++size;
        }
        else
            increaseCapacity(); 
    }

    public E pop() throws EmptyStackException{
        if(isEmpty())
        throw new EmptyStackException("Pilha vazia");
        return a[top--]; 
    }
    
    public E top() throws EmptyStackException{
        if(isEmpty())
        throw new EmptyStackException("Pilha vazia!");
        return a[top];
    }

    public void increaseCapacity(){
        cap*=2;
        E[] newArray = (E[]) new Object[cap];
        for(int i = 0; i < size; i++)
            newArray[i] = a[i];
        a = newArray;
        System.out.printf("Capacidade ampliada para %d elementos\n", cap);
    }

    public String toString(){
        String s = "[";
        for(int i = 0; i < size; i++){
            s += a[i];
            if(i != size-1)
                s += ", ";
        }
        s += "]";
        return s;
    }

}
