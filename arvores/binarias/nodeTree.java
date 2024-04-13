package arvores.binarias;

public class nodeTree<E> {
    protected E elemento;
    protected nodeTree<E> tico;
    protected nodeTree<E> teco;
    protected nodeTree<E> pai;
    public nodeTree(){
        elemento = null;
        tico = new nodeTree<E>();
        teco = new nodeTree<E>();
        pai = new nodeTree<E>();
    }
    public nodeTree(E e, nodeTree<E> p, nodeTree<E>fd, nodeTree<E> fe){
        setElement(e);
        setRight(fd);
        setLeft(fe);
        setParent(p);
    }
    public void setElement(E e){elemento = e;}
    public void setParent(nodeTree<E> p){pai = p;}
    public void setRight(nodeTree<E> f){tico = f;}
    public void setLeft(nodeTree<E> f){teco = f;}
    public E getElement(){return elemento;}
    public nodeTree<E> getParent(){return pai;}
    public nodeTree<E> getRight(){return tico;}
    public nodeTree<E> getLeft(){return teco;}
}
