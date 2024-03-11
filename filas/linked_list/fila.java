package linked_list;
public class fila {
        public static void main(String[] args) {
          NodeQueue<Object> fila = new NodeQueue<Object>();
          for (int i = 0; i < 10; i++)
            fila.enqueue(i + 1);
          System.out.println(fila);
          fila.inverter();
          System.out.println(fila);
          
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
}
