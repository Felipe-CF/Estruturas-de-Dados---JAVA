package listas.linked_list;

public class teste_lista {
    public static void main(String[] args){
        Lista<Object> lista = new Lista<Object>();
        System.out.println(lista);
        Node<Object> no;
        for(int i = 0; i < 10; i++){
            no = new Node<Object>(i+1);
            lista.insertLast(no);
            //ista.insertFirst(no);
        }
        // no = new Node<Object>(1);
        // System.out.println(lista.remove(no));

        //  no = new Node<Object>(5);
        // lista.replaceElement(no, 11);
        // System.out.println(lista);

        Node<Object> no1 = new Node<Object>(1);
        Node<Object> no2 = new Node<Object>(10);   
        lista.swapElements(no1, no2);
        System.out.println(lista);
    }
}
