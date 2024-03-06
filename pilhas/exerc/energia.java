package exerc;
import java.util.Scanner;
import java.util.ArrayList;
import linkedList.NodeStack;
import linkedList.NodeStack.Node;
import linkedList.pilha;

public class energia{
    public static void main(String[] args){
       NodeStack<Integer> linhas = new NodeStack<Integer>();
       linhas.push(5);
       linhas.push(7);
       linhas.push(2);
       linhas.push(6);
       linhas.push(3);
       System.out.println(linhas.top());
       NodeStack<Integer> p = new NodeStack<Integer>();
       
        do{

            // linhas.last().getNext().getElem() ==> pegar o elemento do penúltimo item empilhado
            if(linhas.top() < linhas.last().getNext().getElem()){

            }
        }while(!p.isEmpty());
 

    }
}