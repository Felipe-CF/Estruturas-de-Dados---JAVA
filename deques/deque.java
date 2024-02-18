package deques;
public class deque {
    public static void main(String[]args){
        NodeDeck<Object> deque = new NodeDeck<Object>();
        for(int i = 10; i > 0; i--){
            deque.addFirst(i);
            System.out.println(deque.toString());
        }
        System.out.println(deque.removeFirst());
        System.out.println(deque.toString());
        System.out.println(deque.removeLast());
        System.out.println(deque.toString());
    }
}
