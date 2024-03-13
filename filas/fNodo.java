import linkedList.NodeStack;
public class fNodo {
    public static void main(String[] args){
        filha<Object> p = new filha<Object>();
        for(int i = 0; i <10;i++){
            p.enqueue(i+1); 
            System.out.println(p);
        }
    }
}
