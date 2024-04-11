package sequencias;

public class teste_sequencia {
    public static void main(String[] args){
        Sequencia<Object> sequencia = new Sequencia<Object>();
        Node<Object> no = new Node<Object>();
         for(int i =0; i < 10; i++){
            no = new Node<Object>(i+1);
            sequencia.insertLast(no);
            //sequencia.insertFirst(no);
         }
         no = new Node<Object>(15);
        
        
        //System.out.println(sequencia.before(no));
        //System.out.println(sequencia.after(no));
        // sequencia.insertAfter(no, 15);
        // sequencia.insertBefore(no, 15);

        // for(int i = 0; i < 10; i++){
        //     no = new Node<Object>(i+1);
        //     System.out.println(sequencia.remove(no));
        //  }
        
        // sequencia.replaceElement(no, 15);

        // Node<Object> no1 = new Node<Object>(2);
        // Node<Object> no2 = new Node<Object>(9);
        // sequencia.swapElements(no1, no2);

        //sequencia.removeAtRank(1);
        //System.out.println(sequencia.elemAtRank(9));
        //sequencia.replaceAtRank(9, no);
        //sequencia.insertAtRank(7, no);

        System.out.println(sequencia);
    }
}
