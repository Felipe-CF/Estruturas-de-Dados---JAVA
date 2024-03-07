package exerc;
import linkedList.NodeStack;

public class energia{
    public static void main(String[] args){
       NodeStack<Integer> linhas = new NodeStack<Integer>();
       linhas.push(5);
       linhas.push(7);
       linhas.push(2);
       linhas.push(6);
       linhas.push(3);
      // System.out.println(linhas);
       NodeStack<Integer>.Node<Integer> cursor; // item da pilha
       NodeStack<Integer> a = new NodeStack<Integer>();
       NodeStack<Integer> b = new NodeStack<Integer>();
       do{
        System.out.println(linhas);
        cursor = linhas.last();
        while (cursor.getNext() != null) {
            if(cursor.getElem() < cursor.getNext().getElem()){
                a.push(cursor.getElem());
                b.push(cursor.getNext().getElem());
            }
            cursor = cursor.getNext();
        }
        if(b.isEmpty()){ // se não for precisa fazer +1 linha
            System.out.println(a);
            break;
        }
        else{ // foi necessário fazer uma nova linha
            System.out.println(b);
            linhas = a;
            b = null;
        }
       } while(!a.isEmpty());

    }
}