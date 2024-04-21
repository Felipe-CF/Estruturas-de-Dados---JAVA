package arvores.binarias;

public class nodeTree<E> {
    protected E elemento;
    protected nodeTree<E> filhoD;
    protected nodeTree<E> filhoE;
    protected nodeTree<E> pai;
    public nodeTree(){
        elemento = null;
        filhoD = new nodeTree<E>();
        filhoE = new nodeTree<E>();
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
    public void setRight(nodeTree<E> f){filhoD = f;}
    public void setLeft(nodeTree<E> f){filhoE = f;}
    public E getElement(){return elemento;}
    public nodeTree<E> getParent(){return pai;}
    public nodeTree<E> getRight(){return filhoD;}
    public nodeTree<E> getLeft(){return filhoE;}
}
