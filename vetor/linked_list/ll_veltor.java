package vetor.linked_list;

public class ll_veltor {
    public static void main(String[] args){
        ll_Vector<Integer> vetor = new ll_Vector<Integer>();
         vetor.insertAtRank(0, 1);
         vetor.insertAtRank(3, 1);
         System.out.println(vetor);
    }
}
