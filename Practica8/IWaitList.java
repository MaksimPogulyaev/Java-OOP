import java.util.Collection;

interface IWaitList<E> {

    void add(E element);

    E remove();

    boolean contains(E element);

    boolean containsAll(Collection<E> c);

    boolean isEmpty();
} 