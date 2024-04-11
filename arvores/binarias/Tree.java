package arvores.binarias;
import java.lang.Iterable;
import java.util.Iterator;

public interface Tree<E> {
    // metodos de arvores
    public boolean isEmpty();
    public int size();
    public int height() throws EmptyTreeException;
    public Iterator<E> elements() throws EmptyTreeException;
    public Iterator<E> nos() throws EmptyTreeException;
    public nodeTree<E> root() throws EmptyTreeException;
    public nodeTree<E> parent(nodeTree<E> n) throws EmptyTreeException;
    public Iterator<E> children(nodeTree<E> n) throws EmptyTreeException;
    public boolean isInternal(nodeTree<E> n) throws EmptyTreeException;
    public boolean isExternal(nodeTree<E> n) throws EmptyTreeException;
    public boolean isRoot(nodeTree<E> n) throws EmptyTreeException;
    public int depth(nodeTree<E> n) throws EmptyTreeException;
    public E replace(nodeTree<E> n, E e) throws EmptyTreeException;

    // metodos de arvores binarias
    public nodeTree<E> leftChild(nodeTree<E> n) throws EmptyTreeException;
    public nodeTree<E> rightChild(nodeTree<E> n) throws EmptyTreeException;
    public boolean hasRight(nodeTree<E> n) throws EmptyTreeException;
    public boolean hasLeft(nodeTree<E> n) throws EmptyTreeException;
}
