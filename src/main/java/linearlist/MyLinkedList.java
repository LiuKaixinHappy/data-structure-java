package linearlist;

public class MyLinkedList<E> implements ListInterface<E> {

    private int length;
    private Node head = null;

    private class Node {
        private E data;
        private Node next;

        private Node(E data) {
            this.data = data;
            this.next = null;
        }

        private Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public boolean add(E object) {
        Node node = new Node(object);
        if (isEmpty()) {
            this.head = node;
        } else {
            try {
                Node lastNode = getNodeAt(this.length - 1);
                lastNode.next = node;
            } catch (RuntimeException e) {
                return false;
            }
        }
        this.length += 1;
        return true;
    }

    @Override
    public boolean addTo(int position, E object) {
        Node node = new Node(object);
        Node preNode = getNodeAt(position - 1);
        node.next = preNode.next;
        preNode.next = node;
        this.length += 1;
        return true;
    }

    @Override
    public E remove(int position) {
        Node removedNode = getNodeAt(position);
        Node preNodeOfRemovedNode = position == 0 ? this.head : getNodeAt(position - 1);
        preNodeOfRemovedNode.next = removedNode.next;
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
        if (position == 0) {
            this.head = new Node(object, this.head.next);
        } else {
            Node preNodeOfReplacedNode = getNodeAt(position - 1);
            preNodeOfReplacedNode.next = new Node(object, preNodeOfReplacedNode.next.next);
        }
        return true;
    }

    @Override
    public E get(int position) {
        return getNodeAt(position).data;
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
        return head == null;
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
        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
}
