package A2;

public class Node<K,E> {
    private K k; // key for this node
    private E v; // value for this node
    private Node<K,E> next; // pointer to next node

    Node(K key, E val, Node<K, E> nextval){ //constructor
        k = key;
        v = val;
        next = nextval;

    }
    /** Set & Get functions for the data members*/
    Node(Node<K,E> nextval){
        next = nextval;
    }

    Node<K,E> next(){
        return next;
    }

    Node<K,E> setNext(Node<K,E> nextval) {
        return next = nextval;
    }
    K k(){
        return k;
    }

    K setK(K key){
        return k = key;
    }

    E v(){
        return v;
    }

    E setV(E val){
        return v = val;
    }
}