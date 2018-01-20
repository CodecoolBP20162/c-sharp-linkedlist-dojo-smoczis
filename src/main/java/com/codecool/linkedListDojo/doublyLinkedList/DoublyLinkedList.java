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
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        size++;
    }

    void prepend(E value) {
        DoubleNode<E> newHead = new DoubleNode<>(value);
        head.setPrevious(newHead);
        newHead.setNext(head);
        head = newHead;
        size++;
    }

    void insert(E value, int index) {

        if(index < 0 || index >= this.size) { throw new IndexOutOfBoundsException("out of index"); }
        else if(index == 0) {
            prepend(value);

        } else {
            DoubleNode<E> newNode = new DoubleNode<>(value);
            insertIntoMiddle(newNode, index);
        }
        size++;
    }

    private void insertIntoMiddle(DoubleNode<E> node, int index) {
        if(index <= this.size/2) {
            insertFromBegin(node, index);
        } else {
            insertFromEnd(node, index);
        }
    }

    private void insertFromBegin(DoubleNode<E> node, int index) {
        DoubleNode<E> temp = head;
        for(int i=1; i<index; i++) {
            temp = temp.getNext();
        }
        temp.getNext().setPrevious(node);
        node.setNext(temp.getNext());
        node.setPrevious(temp);
        temp.setNext(node);
    }

    private void insertFromEnd(DoubleNode<E> node, int index) {
        DoubleNode<E> temp = last;
        for(int i=size-1; i>index; i--) {
            temp = temp.getPrevious();
        }
        temp.getPrevious().setNext(node);
        node.setPrevious(temp.getPrevious());
        node.setNext(temp);
        temp.setPrevious(node);
    }

    void delete(E value) {

        if(head == null) {
            throw new NullPointerException("null");

        } else if (head.getValue() == value) {
            head = head.getNext();
            head.setPrevious(null);

        } else if (last.getValue() == value) {
            last = last.getPrevious();
            last.setNext(null);

        } else {
            deleteMiddle(value);
        }

        size--;
    }

    private void deleteMiddle(E value) {
        DoubleNode<E> current = last;

        while(current.getPrevious() != null) {

            if(current.getPrevious().getValue() == value) {
                current.getPrevious().getPrevious().setNext(current);
                current.setPrevious(current.getPrevious().getPrevious());
            }
            current = current.getPrevious();
        }
    }

    void deleteWithIndex(int index) {
        if(index < 0 || index >= this.size) { throw new IndexOutOfBoundsException("out of index"); }

        DoubleNode<E> temp;
        if(index == 0) {
            head.getNext().setPrevious(null);
            head = head.getNext();

        } else if(index == size-1) {
            last.getPrevious().setNext(null);
            last = last.getPrevious();

        } else {

            if(index < this.size/2) {
                deleteFromBegin(index);
            } else {
                deleteFromEnd(index);
            }
        }
        size--;
    }

    private void deleteFromBegin(int index) {
        DoubleNode<E> temp = head;
        for(int i=1; i<index; i++) {
            temp = temp.getNext();
        }
        temp.getNext().getNext().setPrevious(temp);
        temp.setNext(temp.getNext().getNext());
    }

    private void deleteFromEnd(int index) {
        DoubleNode<E> temp = last;
        for(int i=size-2; i>index; i--) {
            temp = temp.getPrevious();
        }
        temp.getPrevious().getPrevious().setNext(temp);
        temp.setPrevious(temp.getPrevious().getPrevious());

    }

    public String toString() {
        StringBuilder result = new StringBuilder("");
        DoubleNode<E> node = this.head;
        while (node != null) {
            result.append(" ").append(node.getValue());
            node = node.getNext();
        }
        return result.toString();
    }

}
