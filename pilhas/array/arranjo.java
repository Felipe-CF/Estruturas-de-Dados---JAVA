package array;

public class arranjo {
    public static void main(String[] args){
        ArrayStack<Object> pilha = new ArrayStack<Object>();
        for(int i = 0; i < 3000; i++){
            pilha.push(i+1);
        }
        System.out.println(pilha);
    }
}
