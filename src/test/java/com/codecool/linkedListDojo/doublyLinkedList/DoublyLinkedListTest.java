package com.codecool.linkedListDojo.doublyLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void sizeTest() {
        DoublyLinkedList<Integer> list = createList(4);
        assertEquals(4, list.size());
    }

    @Test
    void appendtSizeTest() {
        DoublyLinkedList<Integer> list = createList(4);
        list.append(112);
        assertEquals(5, list.size());
    }

    @Test
    void appendTest() {
        DoublyLinkedList<Integer> list = createList(5);
        list.append(9);
        list.append(32);

        String result = " 0 1 2 3 4 9 32";
        assertEquals(result, list.toString());
    }

    @Test
    void prependTest() {
        DoublyLinkedList<Integer> list = createList(5);
        list.prepend(12);
        list.prepend(9);

        String result = " 9 12 0 1 2 3 4";
        assertEquals(result, list.toString());
    }

    @Test
    void deleteTest() {
        DoublyLinkedList<Integer> list = createList(5);
        list.delete(3);
        list.delete(0);

        String result = " 1 2 4";
        assertEquals(result, list.toString());
    }

    @Test
    void deleteWithIndexTest() {
        DoublyLinkedList<Integer> list = createList(10);
        list.deleteWithIndex(3);
        list.deleteWithIndex(5);

        String result = " 0 1 2 4 5 7 8 9";
        assertEquals(result, list.toString());
    }

    @Test
    void deleteWithIndexOutOfSizeTest() {
        DoublyLinkedList<Integer> list = createList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteWithIndex(-2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteWithIndex(11));

    }

    @Test
    void insertTest() {
        DoublyLinkedList<Integer> list = createList(10);
        list.insert(12, 7);
        list.insert(111, 2);

        String result = " 0 1 111 2 3 4 5 6 12 7 8 9";
        assertEquals(result, list.toString());
    }

    @Test
    void insertOutOfIndexTest() {}

    @Test
    void deleteEmptyListTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertThrows(NullPointerException.class, () -> list.delete(3));
    }

    private DoublyLinkedList<Integer> createList(int numOfElems) {
        DoublyLinkedList<Integer> result = new DoublyLinkedList<>();
        for(int i=0; i<numOfElems; i++) {
            result.append(i);
        }
        return result;
    }

}