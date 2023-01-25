package datastructures

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class QueueTest {

    private lateinit var queue: Queue<Int>

    @BeforeEach
    internal fun setUp() {
        queue = Queue()
        queue.enqueue(1)
        queue.enqueue(2)
    }

    @Test
    fun `enqueue should add element at last`() {
        assertEquals(2, queue.rear())
        assertEquals(2, queue.length)
    }

    @Test
    fun `dequeue should remove first element`() {
        assertEquals(1, queue.dequeue())
        assertEquals(1, queue.length)
    }

    @Test
    fun `peek should return first element in queue without removing it`() {
        assertEquals(1, queue.peek())
        assertEquals(2, queue.length)
    }

    @Test
    fun `rear should return last element in queue without removing it`() {
        assertEquals(2, queue.rear())
        assertEquals(2, queue.length)
    }
}