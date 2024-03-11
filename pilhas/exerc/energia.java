package exerc;
import java.util.ArrayList;
import array.ArrayStack;

public class energia{
    public static void main(String[] args){
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2;  
        ArrayStack<Integer> p = new ArrayStack<Integer>(); // pilha usada para armazenar a nova linha de força
        
        // a1.add(3);
        // a1.add(6);
        // a1.add(2);
        // a1.add(7);
        // a1.add(5);
        a1.add(8);
        a1.add(6);
        a1.add(10);
        a1.add(4);
        a1.add(1);
        a1.add(5);
        a1.add(3);
 
        while(a1.size() != 0){
            a2 = new ArrayList<Integer>();
            if(a1.size() == 1){
                p.push(a1.get(0));
            }
            else{
                for(int i = 1; i < a1.size();i++){
                    if(a1.get(i) > a1.get(i-1)){
                        if(a2.size() == 0){
                            if(p.isEmpty()){
                                a2.add(a1.get(i-1)); p.push(a1.get(i));
                            }
                            else{
                                if(p.top() != a1.get(i-1))
                                    p.push(a1.get(i-1));
                                a2.add(a1.get(i)); 
                            }
                        }
                        else{
                            a2.add(a1.get(i));
                        }
                    }
                    else{
                        if(p.isEmpty()){
                            p.push(a1.get(i-1));
                        }
                        p.push(a1.get(i));
                    }
                }
               // p.inverter(); // inverte a pilha para impressão na ordem certa
                System.out.println(p);
                while(!p.isEmpty())
                    p.clear();
                if(a2.size() == 1){
                    System.out.println(a2);
                    break;
                }
                a1 = a2; // atualizo a referencia da linha orignal para os valores restantes que não foram
                // destinadas a uma linha ainda
            
            }
        }   

        
    }
}