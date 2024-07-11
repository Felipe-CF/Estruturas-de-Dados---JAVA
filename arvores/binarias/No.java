package arvores.binarias;

public class No<E> {
    protected E elemento;
    protected No<E> fe, fd;
    protected No<E> pai;
    public No(){
        elemento = null;
        fd = new No<E>();
        fe = new No<E>();
        pai = new No<E>();
    }
    public No(E e, No<E> p, No<E>fe, No<E> fd){
        setElemento(e);
        setFilhoDireito(fd);
        setFilhoEsquerdo(fe);
        setPai(p);
    }
    public void setElemento(E e){elemento = e;}
    public void setPai(No<E> p){pai = p;}
    public void setFilhoDireito(No<E> f){fd = f;}
    public void setFilhoEsquerdo(No<E> f){fe = f;}
    public Integer getElemento(){return (Integer) elemento;}
    public No<E> getPai(){return pai;}
    public No<E> getFilhoDireito(){return fd;}
    public No<E> getFilhoEsquerdo(){return fe;}
}
