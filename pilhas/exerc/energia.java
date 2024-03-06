package exerc;
import java.util.Scanner;
import java.util.ArrayList;
import linkedList.NodeStack;
//import filas.array.NodeQueue;
import linkedList.pilha;

public class energia{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
       ArrayList<Integer> a, novo_a, nova_linha;
       NodeStack<Object> linhas = new NodeStack<Object>();
        a = new ArrayList<Integer>();
        while(s.hasNextInt())
            a.add(s.nextInt());

        do{
            novo_a = new ArrayList<Integer>(); // linha antiga
            nova_linha = new ArrayList<Integer>(); // nova linha formada
            for(int i = 0; i < a.size()-1; i++){
                if(a.get(i) < a.get(i+1))
                    novo_a.add(a.get(i));      
                nova_linha.add(a.get(i+1));
            }
            if(novo_a.size() == 0){ // se a linha antiga estiver ok, o laço vai parar
                linhas.push(a); 
                break;
            } 
            linhas.push(nova_linha);
            System.out.println(linhas);

            a = novo_a;
        }while(a.size() != 0);
        

    }
}