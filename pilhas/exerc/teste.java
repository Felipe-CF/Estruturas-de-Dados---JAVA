package exerc;
import linkedList.NodeStack;
import linked_list.NodeQueue;
public class teste {
    public static void main(String[] args){
        NodeQueue<Object> p = new NodeQueue<Object>();
        NodeQueue<Object> c = new NodeQueue<Object>();
        for(int i = 0; i <10;i++)
            p.enqueue(i+1);
        while(p.size() > 1)
            c.enqueue(p.dequeue());
        System.out.println(p); 
    }
}
