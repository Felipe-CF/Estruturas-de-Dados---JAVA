import linkedList.NodeStack;

public class filha<E> {
    // 2 pilhas
    protected NodeStack<E> p1;
    protected NodeStack<E> p2;
    protected int size;
    protected NodeStack<E>.Node<E> first;
    protected NodeStack<E>.Node<E> last;
    public filha(){
        p1 = new NodeStack<E>();    p2 = new NodeStack<E>();
        last=p1.last();             first=p2.last();
        size=0;
    }   
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        return p2.last().getElem();
    }
    public void enqueue(E e){
        NodeStack<E> p = new NodeStack<E>();
        NodeStack<E>.Node<E> new_node = p.new Node<E>(e);
        p1.push(e);
    }



}
