package linear.stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInterface<E>{

    private Node head = null;
    private Node top = null;

    private class Node {
        private E data;
        private Node next;
        private Node prev;

        private Node(E data) {
            this.data = data;
        }
    }

    @Override
    public boolean push(E object) {
        if (isEmpty()) {
            head = new Node(object);
            top = head;
        } else {
            Node newElem = new Node(object);
            top.next = newElem;
            newElem.prev = top;
            top = top.next;
        }
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = top;
        top = top.prev;
        if (top != null) {
            top.next = null;
        }
        return temp.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        StringBuilder elems = new StringBuilder();
        Node temp = top;
        while (temp != null) {
            elems.append(temp.data).append("\n");
            temp = temp.prev;
        }
        System.out.print(elems.toString());
    }
}
