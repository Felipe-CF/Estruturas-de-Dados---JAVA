package arvores.binarias;
import java.lang.Iterable;
import java.util.Iterator;

public class BinaryTree<E> implements Tree<E> {
    protected nodeTree<E> root;
    public BinaryTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){ // implementar
        return 1;
    }

    public nodeTree<E> root() throws EmptyTreeException{
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        return root;
    }

    public nodeTree<E> parent(nodeTree<E> n) throws EmptyTreeException{
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        if(n.getElement() == root.getElement())
            System.out.println("A raiz não tem pai, meu nobre");
        return n.getParent();
    }

    // public Iterator<E> children(nodeTree<E> n) throws EmptyTreeException{
    //     if(isEmpty())
    //         throw new EmptyTreeException("Arvore vazia");
        
    // }

    public boolean isExternal(nodeTree<E> n) throws EmptyTreeException {
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        return (n.getLeft() == null) && (n.getRight() == null);
    }

    public boolean isInternal(nodeTree<E> n) throws EmptyTreeException {
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        return (n.getLeft() != null) && (n.getRight() != null);
    }

    public boolean isRoot(nodeTree<E> r) throws EmptyTreeException{
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        if(r.getElement() == root.getElement())
            return true;
        return false;
    }

    public int depth(nodeTree<E> n) throws EmptyTreeException{ // imp
        return 1;
    }

    public E replace(nodeTree<E> n, E e) throws EmptyTreeException{
        return null;
    }

    public nodeTree<E> leftChild(nodeTree<E> n) throws EmptyTreeException{
        return root;
    } 

    public nodeTree<E> rightChild(nodeTree<E> n) throws EmptyTreeException{
        return root;
    }

    public boolean hasRight(nodeTree<E> n) throws EmptyTreeException{
        return false;
    }

    public boolean hasLeft(nodeTree<E> n) throws EmptyTreeException{
        return false;
    }

    public String toString(){
        return "i";
    }


}
