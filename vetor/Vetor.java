package vetor;

public interface Vetor<E>{
    public E elemAtRank(int i) throws IndexOutOfBoundaries;
    public E replaceAtRank(int i, E e) throws EmptyStackException, IndexOutOfBoundaries;
    public void insertatRank(in i, E e)throws IndexOutOfBoundaries;
}