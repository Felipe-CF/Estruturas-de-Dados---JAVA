package array;

public class fila {
    public static void main(String[] args){
        ArrayQueue<Object> fila = new ArrayQueue<Object>();
        for(int i = 0; i < 5; i++)
            fila.enqueue(i+1);
        System.out.println(fila);
    }
}
