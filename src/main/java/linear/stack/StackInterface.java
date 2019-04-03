package linear.stack;

public interface StackInterface<E> {
    boolean push(E object);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();

    void display();
}
