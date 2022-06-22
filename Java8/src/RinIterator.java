import java.util.Iterator;

public class RinIterator <T> implements Iterator<T> {

    Node<T> current;
    public RinIterator(Rin<T> nir){
        current=nir.getHead();
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T data= current.getData();
        current=current.getNext();
        return data;
    }

    @Override
    public void remove() {
        throw
                new UnsupportedOperationException();
    }
}
