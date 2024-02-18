package LInkedList;
public class fila {
        public static void main(String[] args) {
          NodeQueue<Object> fila = new NodeQueue<Object>();
          System.out.println(fila.toString());
          for (int i = 0; i < 10; i++)
            fila.enqueue(i + 1);
          System.out.println(fila.toString());
          System.out.println(fila.dequeue());
          System.out.println(fila.toString());
          System.out.println(fila.dequeue());
          System.out.println(fila.toString());
        }
}
