package vetor.array;

public class Vector<E> implements Vetor<E> {
    protected E[] a;
    protected int size;
    protected int cap;
    protected int last;
    public Vector(){
        last=-1;
        size = 0;
        cap=1;
        a = (E[]) new Object[cap];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public boolean indexCheck(int i) throws IndexOutOfBoundsException{
        return (i<0) || (i >= cap);
    }
    private void sizeCheck(){
        if(size == cap)
            increaseCapacity();
        else if(size <= (cap*0.25))
            decreaseCapacity();
    }
    public void increaseCapacity(){
        cap*=2;
        E[] newArray = (E[]) new Object[cap];
        for(int i = 0; i < size; i++)
            newArray[i] = a[i];
        a = newArray;
    //   System.out.printf("Capacidade ampliada para %d elementos\n", cap);
    }
    private void decreaseCapacity(){ 
        cap/=2;
        E[] newArray = (E[]) new Object[cap];
        for(int i = 0; i < size; i++)
            newArray[i] = a[i];
        a = newArray;
    //    System.out.printf("Capacidade reduzida para %d elementos\n", cap);
    }

    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if(indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        return a[i];
    }

    public E replaceAtRank(int i, E e) throws EmptyVectorException, IndexOutOfBoundsException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if(indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        E temp = a[i];
        a[i] = e;
        return temp;
    }

    public void insertAtRank(int i, E e) throws EmptyVectorException, IndexOutOfBoundsException{
        if(isEmpty() && i != 0)
            throw new EmptyVectorException("Vetor vazio");
        if(indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        a[i] = e;
        size++;
        last++;
        sizeCheck(); // ampliar quando estiver cheio
    }

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if(indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        E temp = a[i];
        for(int j = i; j < last; j++)
            a[j] = a[j+1];
        last--;
        size--;
        sizeCheck();
        return temp;
    }
    
    public String toString(){
        String s = "[";
        if(!isEmpty()){
            for(int j = 0; j < size; j++){
                s += a[j];
                if(j < size-1)
                    s += ", ";
            }
        }
        return s + "]";
    }

}
