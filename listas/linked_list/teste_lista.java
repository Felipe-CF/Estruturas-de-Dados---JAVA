package listas.linked_list;

public class teste_lista {
    public static void main(String[] args){
        Lista<Object> lista = new Lista<Object>();
        System.out.println(lista);
        Node<Object> no;
        for(int i = 0; i < 10; i++){
            no = new Node<Object>(i+1);
            //lista.insertLast(no);
            lista.insertFirst(no);
        }
        System.out.println(lista);
    }
}
