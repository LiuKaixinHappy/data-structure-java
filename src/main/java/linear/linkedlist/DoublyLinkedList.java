package linear.linkedlist;

public class DoublyLinkedList<E> implements ListInterface<E> {

    private Node head;
    private int length;

    private class Node {
        private E data;
        private Node next;
        private Node prev;

        private Node(E data) {
            this.data = data;
        }

        private Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public boolean add(E object) {
        Node node = new Node(object);
        if (isEmpty()) {
            this.head = node;
        } else {
            Node lastNode = getNodeAt(this.length - 1);
            node.prev = lastNode;
            lastNode.next = node;
        }
        this.length += 1;
        return true;
    }

    private Node getNodeAt(int position) {
        if (isEmpty()) {
            throw new RuntimeException("Empty List!");
        }
        if (position >= length || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node pointer = this.head;
        for (int i = 0; i < position; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    @Override
    public boolean addTo(int position, E object) {
        Node node = new Node(object);
        Node pointer = getNodeAt(position);
        pointer.prev.next = node;
        node.prev = pointer.prev;
        pointer.prev = node;
        node.next = pointer;
        this.length += 1;
        return true;
    }

    @Override
    public E remove(int position) {
        Node removedNode = getNodeAt(position);
        if (removedNode.prev != null) {
            removedNode.prev.next = removedNode.next;
        }
        if (removedNode.next != null) {
            removedNode.next.prev = removedNode.prev;
        }
        this.length -= 1;
        return removedNode.data;
    }

    @Override
    public boolean clear() {
        this.head = null;
        this.length = 0;
        return true;
    }

    @Override
    public boolean replace(int position, E object) {
        Node pointer = getNodeAt(position);
        Node node = new Node(object, pointer.prev, pointer.next);
        if (node.prev == null) {
            this.head = node;
        } else {
            node.prev.next = node;
        }
        if (node.next != null) {
            node.next.prev = node;
        }
        return true;
    }

    @Override
    public E get(int position) {
        return getNodeAt(position).data;
    }

    @Override
    public boolean contains(E object) {
        Node pointer = this.head;
        while (pointer != null) {
            if (pointer.data == object) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        Node pointer = this.head;
        if (pointer == null) {
            System.out.println("List is EMPTY!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (pointer != null) {
            stringBuilder
                    .append("prev:")
                    .append(pointer.prev == null ?
                            "null" : pointer.prev.data)
                    .append("\tcurr:")
                    .append(pointer.data)
                    .append("\tnext:")
                    .append(pointer.next == null ?
                            "null" : pointer.next.data)
                    .append("\n");
            pointer = pointer.next;
        }
        System.out.print(stringBuilder.toString());
    }
}
