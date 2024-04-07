package listas.array;

public class teste_lista {
    public static void main(String args[]){
        Lista<Object> lista = new Lista<Object>();
        System.out.println(lista);

        Node<Object> no = new Node<Object>();
        for(int i =0; i < 10; i++){
            no = new Node<Object>(i+1);
            // lista.insertLast(no);
            // lista.insertFirst(no);
        }
        no = new Node<Object>(25);
        // lista.insertBefore(no, 15);
        //lista.insertAfter(no, 15);


        // System.out.println(lista.remove(no));
        //System.out.println(lista);

        // Lista<Object> lista1 = new Lista<Object>();
        // lista1.replaceElement(no ,16);

        // Node<Object> no1 = new Node<Object>(5);
        // Node<Object> no2 = new Node<Object>(2);
        // lista.swapElements(no1 ,no2);

         System.out.println(lista);
    }
}
