package com.codecool.linkedListDojo.singlyLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void sizeTest() {
        SinglyLinkedList<Integer> list = createList(5);
        assertEquals(5, list.size());
    }

    @Test
    void appendTest() {
        SinglyLinkedList<Integer> list = createList(10);
        list.append(14);
        list.append(21);

        String result = " 0 1 2 3 4 5 6 7 8 9 14 21";
        assertEquals(result, list.toString());
    }

    @Test
    void removeTest() {
        SinglyLinkedList<Integer> list = createList(10);
        list.delete(5);
        list.delete(9);

        String result = " 0 1 2 3 4 6 7 8";
        assertEquals(result, list.toString());
    }

    @Test
    void removeEmptyListTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        assertThrows(NullPointerException.class, () -> list.delete(3));
    }

    @Test
    void prependTest() {
        SinglyLinkedList<Integer> list = createList(5);
        list.prepend(8);
        list.prepend(13);

        String result = " 13 8 0 1 2 3 4";
        assertEquals(result, list.toString());
    }

    @Test
    void insertTest() {
        SinglyLinkedList<Integer> list = createList(5);
        list.insert(10, 3);
        list.insert(8, 1);

        String result = " 0 8 1 2 10 3 4";
        assertEquals(result, list.toString());
    }

    @Test
    void insertOutOfIndexTest() {
        SinglyLinkedList<Integer> list = createList(4);

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(2, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(3, -2));
    }

    private SinglyLinkedList<Integer> createList(int numOfElems) {
        SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
        for(int i=0; i<numOfElems; i++) {
            result.append(i);
        }
        return result;
    }

}