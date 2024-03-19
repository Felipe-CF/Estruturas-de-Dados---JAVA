package vetor;
//import java.lang.IndexOutOfBoundsException;
public interface Vetor<E>{
    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException;
    public E replaceAtRank(int i, E e) throws EmptyVectorException, IndexOutOfBoundsException;
    public void insertAtRank(int i, E e)throws IndexOutOfBoundsException;
    public E removeAtRank(int i) throws EmptyVectorException, IndexOutOfBoundsException;; 
    public int size();
    public boolean isEmpty();
    public boolean indexCheck(int i) throws IndexOutOfBoundsException;
}