package exerc;
import linkedList.NodeStack;

public class energia{
    public static void main(String[] args){
        int[] a = {3, 6, 2, 7, 5};
       NodeStack<Object> p = new NodeStack<Object>();
       NodeStack<Object> l = new NodeStack<Object>();
       NodeStack<Object> r = new NodeStack<Object>();
       p.push(5);
       p.push(7);
       p.push(2);
       p.push(6);
       p.push(3);
//      NodeStack<Object>.Node<Object> cursor = p.last();

        for(int i=1; i < a.length; i++){
            // int e = a[i];
            System.out.println(a[i]);
            if(a[i] > a[i-1]){ // a casa atual tem que sair da linha
                l.push(a[i]);
            }
            else{
                r.push(a[i+1]);    
            }
        }
        System.out.println(l);

        // while(p.size() > 2){
        //     Object o = p.pop();
        //     if((int)o < (int)p.top())
        //         r.push(o);
        //     else
        //         l.push(o);
        // }
        
    }
}