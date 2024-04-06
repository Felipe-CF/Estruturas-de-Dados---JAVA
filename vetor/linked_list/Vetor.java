package vetor.linked_list;

public interface Vetor<E>{
    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException;
    public E replaceAtRank(int i, E o) throws EmptyVectorException, IndexOutOfBoundsException;
    public void insertAtRank(int i, E o)throws IndexOutOfBoundsException;
    public E removeAtRank(int i) throws EmptyVectorException, IndexOutOfBoundsException;; 
    public int size();
    public boolean isEmpty();
}