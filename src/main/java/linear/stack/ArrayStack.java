package linear.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements StackInterface<E> {

    private int n;
    private Object[] elements;
    private int topIndex;

    public ArrayStack(int n) {
        this.n = n;
        this.elements = new Object[n];
        this.topIndex = -1;
    }

    @Override
    public boolean push(Object object) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        elements[++topIndex] = object;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E top = (E)elements[topIndex];
        this.topIndex -= 1;
        return top;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E)elements[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public boolean isFull() {
        return topIndex == n - 1;
    }

    @Override
    public void display() {
        StringBuilder elems = new StringBuilder();
        for (int i = topIndex; i >= 0; i--) {
            elems.append(elements[i]).append("\n");
        }
        System.out.print(elems.toString());
    }
}
