package com.codecool.linkedListDojo.doublyLinkedList;

public class DoublyLinkedList<E> {

    private DoubleNode<E> head;
    private DoubleNode<E> last;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    int size() {
        return this.size;
    }

    void append(E value) {

        DoubleNode<E> node = new DoubleNode<>(value);

        if(head == null) {
            head = node;
            last = node;

        } else {

        }
    }

}
