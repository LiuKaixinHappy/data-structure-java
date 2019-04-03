package linear.linkedlist;

public interface ListInterface<E> {
    boolean add(E object);

    boolean addTo(int position, E object);

    E remove(int position);

    boolean clear();

    boolean replace(int position, E object);

    E get(int position);

    boolean contains(E object);

    int getLength();

    boolean isEmpty();

    boolean isFull();

    void display();
}
