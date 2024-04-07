package listas.array;

public class teste_lista {
    public static void main(String args[]){
        Lista<Object> lista = new Lista<Object>();
        System.out.println(lista);
        Node<Object> no = new Node<Object>();
        for(int i =0; i < 10; i++){
            no = new Node<Object>(i+1);
            lista.insertLast(no);
        }
        no = new Node<Object>(10);
        // lista.insertBefore(no, 15);
        //lista.insertAfter(no, 15);
         System.out.println(lista.remove(no));
        // no = new Node<Object>(3);
        // lista.insertLast(no);
        // System.out.println(lista);
    }
}
