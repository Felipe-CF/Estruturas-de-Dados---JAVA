public class pilha {
    public static void main(String[] args){
        NodeStack<Object> pilha = new NodeStack<Object>();
        pilha.push("a");
        pilha.push(1);
        pilha.push(10.5423);
        System.out.println(pilha);
        pilha.pop();
        System.out.println(pilha.top());
        System.out.println(pilha.size());
        System.out.println(pilha.isEmpty());
    }
}
