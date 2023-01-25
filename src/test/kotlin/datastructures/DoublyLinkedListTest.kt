package datastructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DoublyLinkedListTest {

    @Test
    fun `get on an empty list should return null`() {
        // Given
        val linkedList = LinkedList<Int>()
        // When
        val item = linkedList.get(0)
        // Then
        assertNull(item)
    }

    @Test
    fun `addToFront should add element at start of list`() {
        // Given
        val linkedList = LinkedList.fromArray(arrayOf(1,2,3,4,5))
        // When
        linkedList.addToFront(99)
        // Then
        assertEquals(6, linkedList.length)
        assertEquals(99, linkedList.get(0))
    }

    @Test
    fun `add should add element at end of list`() {
        // Given
        val linkedList = LinkedList.fromArray(arrayOf(1,2,3,4,5))
        // When
        linkedList.add(99)
        // Then
        assertEquals(6, linkedList.length)
        assertEquals(99, linkedList.get(5))
    }

    @Test
    fun `remove front should remove first element in list`() {
        // Given
        val linkedList = LinkedList.fromArray(arrayOf(1,2,3,4,5))
        // When
        linkedList.removeFront()
        // Then
        assertEquals(4, linkedList.length)
        assertEquals(2, linkedList.get(0))
    }

    @Test
    fun `remove last should remove last element in list`() {
        // Given
        val linkedList = LinkedList.fromArray(arrayOf(1,2,3,4,5))
        // When
        linkedList.removeLast()
        // Then
        assertEquals(4, linkedList.length)
    }

    @Test
    fun `removeAt should remove element at passed index`() {
        // Given
        val linkedList = LinkedList.fromArray(arrayOf(1,2,3,4,5))
        // When
        linkedList.removeAt(2)
        // Then
        assertEquals(4, linkedList.get(2))
        assertEquals(4, linkedList.length)
    }

    @Test
    fun `insertAt should insert element at passed index`() {
        // Given
        val linkedList = LinkedList.fromArray(arrayOf(1,2,3,4,5))
        // When
        linkedList.insertAt(3, 99)
        // Then
        assertEquals(6, linkedList.length)
        assertEquals(99, linkedList.get(3))
        assertEquals(4, linkedList.get(4))
    }
}
