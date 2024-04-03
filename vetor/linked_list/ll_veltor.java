package vetor.linked_list;

public class ll_veltor {
    public static void main(String[] args){
        ll_Vector<Integer> vetor = new ll_Vector<Integer>();
        System.out.println(vetor);
        Node<Integer> n = new Node<Integer>(5);
        vetor.insertAtRank(0, n);
        System.out.println(vetor);

    }
}
