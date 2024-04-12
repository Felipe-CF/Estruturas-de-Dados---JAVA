package arvores.binarias;
import java.lang.Iterable;
import java.util.Iterator;

public class ArvoreBinaria<E> implements Tree<E> {
    protected nodeTree<E> raiz;
    protected int nos;
    public ArvoreBinaria(){
        raiz = null;
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
        return raiz.getFilhoEsquerda();
    }

    public nodeTree<E> parent(nodeTree<E> n) throws EmptyTreeException{
        if(isEmpty())
            throw new EmptyTreeException("Arvore vazia");
        if(n.getPai() == null)
            System.out.println("A raiz não tem pai, meu nobre");
        return n.getPai();
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

}
