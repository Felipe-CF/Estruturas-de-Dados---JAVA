package listas.array;

public class Lista {
    public class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;
        public Node() {element = null; next = null; prev = null;}
        public Node(E e) {element = e;}
        public E getElement() {return element;}
        public void setElement(E newElem) {element = newElem;}
        public void setNext(Node<E> newNext) {next = newNext;}
        public Node<E> getNext() {return next;}
        public void setPrev(Node<E> newPrev) {prev = newPrev;}
        public Node<E> getPrev() {return prev;}
      }
}
