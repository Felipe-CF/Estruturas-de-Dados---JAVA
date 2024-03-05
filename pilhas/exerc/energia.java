package exerc;
import java.util.Scanner;
import linkedList.NodeStack;

public class energia{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        NodeStack<Object> pilha = new NodeStack<Object>();
        //NodeStack<Object> pilha = new NodeStack<Object>();
        for(int i = 0; i < 10; i++){
            NodeStack<Object> nova_pilha = new NodeStack<Object>();
            for(int j = 0; j < 10; j++)
                nova_pilha.push(j+i);
            pilha.push(nova_pilha);
        }
        //  while(s.hasNextInt()){
        //  }
        // //     x = ;
        System.out.println(pilha);
    }
}