package com.codecool.linkedListDojo.singlyLinkedList;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    int size() {
        return this.size;
    }

    void append(E value) {

        Node<E> el = new Node<>(value);

        if(head == null) {
            head = el;
            last = el;

        } else {
            last.setNext(el);
            last = el;
        }
        size++;
    }

    void prepend(E value) {

        Node<E> newHead = new Node<>(value);
        newHead.setNext(this.head);
        this.head = newHead;
        size++;
    }

    void delete(E value) {

        if(this.head == null) {
            throw new NullPointerException("null");

    } else if(this.head.getValue() == value) {
            head = head.getNext();

        } else if(this.last.getValue() == value) {
            deleteLast(value);

        } else {
            deleteMiddle(value);
        }
        size--;
    }

    private void deleteLast(E value) {
        Node temp = this.head;

        while (temp.getNext() != this.last) {
            temp = temp.getNext();
        }
        this.last = temp;
        this.last.setNext(null);
    }

    private void deleteMiddle(E value) {
        Node current = head;

        while (current.getNext() != null) {

            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }

    void insert(E value, int index) {

        Node<E> newNode = new Node<>(value);

        if(index >= this.size || index < 0) { throw new IndexOutOfBoundsException("wrong index"); }

        else if(index == 0) {
            prepend(value);

        } else {
            Node<E> temp = head;
            for(int i=1; i<index; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        this.size++;
    }

public String toString() {
    StringBuilder result = new StringBuilder("");
    Node node = this.head;
    while (node != null) {
        result.append(" ").append(node.getValue());
        node = node.getNext();
    }
    return result.toString();
}
}
