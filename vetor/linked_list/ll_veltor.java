package vetor.linked_list;

public class ll_veltor {
    public static void main(String[] args){
        ll_Vector<Integer> vetor = new ll_Vector<Integer>();
        System.out.println(vetor);
        Node<Integer> n = new Node<Integer>();
        for(int i = 0; i < 17; i++){
            n = new Node<Integer>(i+1);
            vetor.insertAtRank(i, n);
        }
        // n = new Node<Integer>(3);
        // vetor.replaceAtRank(0, n);

         System.out.println(vetor);

    }
}
