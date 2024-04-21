package teste;
import java.util.Iterator;
import java.lang.Iterable;

public class teste {
    public static void main(String args[]){
        ll_Vector<Object> v = new ll_Vector<Object>();
        v.insertAtRank(0, 1);
        v.insertAtRank(1, 2);
        v.insertAtRank(2, 3);
        v.insertAtRank(3, 4);
        v.insertAtRank(4, 5);
        // Node<Object> n1 = new Node<Object>(1);
        // Node<Object> n2 = new Node<Object>(1);
        // Node<Object> n3 = new Node<Object>(1);
        // Node<Object> n4 = new Node<Object>(1);
        // Node<Object> n5 = new Node<Object>(1);
        // n1.setNext(n2);
        // n2.setNext(n3);
        // n3.setNext(n4);
        // n4.setNext(n5);
        Iterator<Object> it = v.iterator();
        System.out.println(v);
        
    }
}
