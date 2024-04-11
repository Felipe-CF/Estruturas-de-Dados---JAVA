package arvores.binarias;

public class nodeTree<E> {
    protected E element;
    protected nodeTree<E> filho_esquerda;
    protected nodeTree<E> filho_direita;
    protected nodeTree<E> pai;
    public nodeTree(){
        element =null;
        filho_esquerda = new nodeTree<E>();
        filho_direita = new nodeTree<E>();
        pai = new nodeTree<E>();
    }
    public void setElement(E e){element = e;}
    public void setPai(nodeTree<E> p){pai = p;}
    public void setFilhoDireita(nodeTree<E> f){filho_direita = f;}
    public void setFilhoEsqerda(nodeTree<E> f){filho_esquerda = f;}
    public E getElement(E e){return element;}
    public nodeTree<E> getPai(nodeTree<E> p){return pai;}
    public nodeTree<E> getFilhoDireita(nodeTree<E> f){return filho_direita;}
    public nodeTree<E> getFilhoEsquerda(nodeTree<E> f){return filho_esquerda;}
}
