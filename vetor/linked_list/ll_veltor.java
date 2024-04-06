package vetor.linked_list;

public class ll_veltor {
    public static void main(String[] args){
        ll_Vector<Object> vetor = new ll_Vector<Object>();
         System.out.println(vetor);
        for(int i = 0; i < 10; i++){
             vetor.insertAtRank(i, i+1);
        }

        vetor.replaceAtRank(5, 15);
         System.out.println(vetor.removeAtRank(9));
         System.out.println(vetor.elemAtRank(9));
         System.out.println(vetor.size());
         System.out.println(vetor.isEmpty());
    }
}
