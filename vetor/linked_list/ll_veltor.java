package vetor.linked_list;

public class ll_veltor {
    public static void main(String[] args){
        ll_Vector<Integer> vetor = new ll_Vector<Integer>();
        System.out.println(vetor);
        for(int i = 0; i < 10; i++) 
            vetor.insertAtRank(i, i+1);
         System.out.println(vetor);
         for(int i = 0; i < 10; i++) {
             System.out.println(vetor.removeAtRank(vetor.size()-1));
         }

    }
}
