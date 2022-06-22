import java.util.Iterator;

public class Rin<T> implements Iterable<T> {
    Node<T> head,tail;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void add(T data){
        Node<T> node = new Node<>(data,null);
        if(head==null){
            tail=head=node;
        }
        else
        {
            tail.setNext(node);
            tail=node;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new RinIterator<T>(this);
    }
}
