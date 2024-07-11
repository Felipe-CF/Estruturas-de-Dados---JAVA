package arvores.binarias;
import java.lang.Exception;

public class ArvorePesquisa<E> {
    private No<E> raiz;
    private int size;

    public ArvorePesquisa(){
        raiz = new No<E>(null, null, null, null);
        size = 0;
     }

    public boolean ehVazia(){
        return size == 0;
    }

    public int tamanho(){
        return size;
    }

    public void fincandoRaiz(E e) throws Exception{
        if(!ehVazia())
            throw new Exception("A arvore ja foi plantada");
        
        No<E> nova_raiz = new No<E>(e, null, null, null);

        raiz.setFilhoEsquerdo(nova_raiz);

        size++;
    }

    public boolean ehRaiz(No<E> n) throws Exception{   //
        if(ehVazia())
            throw new Exception("A arvore não existe");

        return raiz.getFilhoEsquerdo().getElemento() == n.getElemento();
    }

    public No<E> aRaiz() throws Exception{   //
        if(ehVazia())
            throw new Exception("A arvore não existe");
        return raiz.getFilhoEsquerdo();
    }

    public boolean temFilhoEsquerdo(No<E> n) throws Exception{
        if(ehVazia())
            throw new Exception("Não existe arvore");
            
        return n.getFilhoEsquerdo() == null;
    }

    public boolean temFilhoDireito(No<E> n) throws Exception{
        if(ehVazia())
            throw new Exception("Não existe arvore");

        return n.getFilhoDireito() == null;
    }

    public boolean ehExterno(No<E> n) throws Exception{
        if(ehVazia())
            throw new Exception("Não existe arvore");
        
        return (n.getFilhoDireito() == null && n.getFilhoEsquerdo() == null);
    }

    public boolean ehInterno(No<E> n) throws Exception{
        if(ehVazia())
            throw new Exception("Não existe arvore");

        return (n.getFilhoDireito() != null || n.getFilhoEsquerdo() != null);
    }

    public No<E> buscaNo(No<E> r, No<E> n) throws Exception{
        if (r.getFilhoEsquerdo().getElemento() <  n.getElemento()) {
            buscaNo(r.getFilhoEsquerdo(), n);
        }
        
        

        return null;
    }

}
