package linkedList;

public class pilha {
    public static void main(String[] args){
        NodeStack<Object> pilha = new NodeStack<Object>();
         for(int i =0;i<10;i++){
             pilha.push(i+1);   
             System.out.println(pilha.top());
         }
        System.out.println(pilha);
        System.out.println(pilha.isEmpty());
        for(int i =0;i<10;i++){
            pilha.pop();
            System.out.println(pilha.size());
            System.out.println(pilha);
        }
        System.out.println(pilha.isEmpty());
    }
}
