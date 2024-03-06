package linkedList;
public class NodeStack<E> implements stack<E> {
    public class Node<E>{
        private E element;
        private Node<E> next;
        public Node(){  element = null; next = null;}
        public Node(E e){element = e;}

        public void setElem(E e)    {element = e;}
        public void setNext(Node<E> n)  {next = n;}
        public E getElem()  {return element;}
        public Node<E> getNext(){return next;}
    }
    private Node<E> top;
    private int size;
    public NodeStack(){
        top = null;
        size = 0;
    }
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    public void push(E e){
        Node<E> newNode = new Node<E>();
        newNode.setElem(e);
        if(size > 0)
            newNode.setNext(top);
        top = newNode;
        size++;
    }
     
    public E pop() throws EmptyStackException{
        if(size == 0)
            throw new EmptyStackException("Pilha vazia");
        Node<E> temp = top;
        top = top.getNext();
        E e = temp.getElem();
        size--;
        return e;
    }

    public E top() throws EmptyStackException{
        if(size == 0)
            throw new EmptyStackException("Pilha vazia");
        return top.getElem();
    }
    
    public Node<E> last() throws EmptyStackException{
        if(size == 0)
            throw new EmptyStackException("Pilha vazia");
        return top;
    }

    public String toString(){
        String s = "[";
        Node<E> current = top;
        while(current != null){
            s += current.getElem();
            if(current.getNext() != null)
                s += ", ";
            current = current.getNext();

        }
        return s + "]";   
    }
}
