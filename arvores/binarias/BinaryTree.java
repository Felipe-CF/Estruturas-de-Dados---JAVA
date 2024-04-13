package arvores.binarias;
import java.lang.Iterable;
import java.util.Iterator;

public class BinaryTree<E> implements Tree<E> {
    protected nodeTree<E> root;
    protected int nos;
    public BinaryTree(){
        root = null;
        nos = 0;
    }

    public boolean isEmpty(){
        return nos == 0;
    }

    public int size(){
        return nos;
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

    public Iterator<E> children(nodeTree<E> n) throws EmptyTreeException{
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        
    }

    public boolean isExternal() throws EmptyTreeException {
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        return raiz.getFilhoEsquerda();
    }


    public nodeTree<E> find(nodeTree<E> n, nodeTree<E> r) throws EmptyTreeException{
        if(n.getElement() == r.getElement())
            return n.getParent();
    }
}
