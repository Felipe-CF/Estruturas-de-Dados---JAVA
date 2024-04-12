package arvores.binarias;

public class nodeTree<E> {
    protected E elemento;
    protected nodeTree<E> filho_esquerda;
    protected nodeTree<E> filho_direita;
    protected nodeTree<E> pai;
    public nodeTree(){
        elemento = null;
        filho_esquerda = new nodeTree<E>();
        filho_direita = new nodeTree<E>();
        pai = new nodeTree<E>();
    }
    public nodeTree(E e, nodeTree<E> p, nodeTree<E>fd, nodeTree<E> fe){
        setElemento(e);
        setFilhoDireita(fd);
        setFilhoEsqerda(fe);
        setPai(p);
    }
    public void setElemento(E e){elemento = e;}
    public void setPai(nodeTree<E> p){pai = p;}
    public void setFilhoDireita(nodeTree<E> f){filho_direita = f;}
    public void setFilhoEsqerda(nodeTree<E> f){filho_esquerda = f;}
    public E getElemento(E e){return elemento;}
    public nodeTree<E> getPai(){return pai;}
    public nodeTree<E> getFilhoDireita(){return filho_direita;}
    public nodeTree<E> getFilhoEsquerda(){return filho_esquerda;}
}
