package vetor.array;

public class veltor {
    public static void main(String[] args){
        Vector<Integer> vetor = new Vector<Integer>();
        for(int i = 0; i < 17; i++){
            vetor.insertAtRank(i, i+1); 
            System.out.println(vetor);

        }

         vetor.insertAtRank(0, 1);
         System.out.println(vetor.replaceAtRank(0, 4));
         vetor.insertAtRank(1, 2);
         System.out.println(vetor.removeAtRank(1));
         System.out.println(vetor);
    }
}
