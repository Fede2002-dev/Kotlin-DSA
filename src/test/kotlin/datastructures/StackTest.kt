package datastructures

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class StackTest {

    @Test
    fun `add multiple element should keep last added in top`() {
        // Given
        val stack = Stack<String>()
        stack.push("test")
        stack.push("test2")
        stack.push("test3")
        // When
        val currentTop = stack.peek()
        // Then
        assertEquals("test3", currentTop)
    }

    @Test
    fun `empty stack should not have any element`() {
        // Given
        val stack = Stack<String>()
        // Then
        assertTrue(stack.isEmpty())
    }

    @Test
    fun `pop should remove last element from stack and return its value`() {
        // Given
        val stack = Stack<String>()
        stack.push("test")
        stack.push("test2")
        // Then
        assertEquals("test2", stack.pop())
        assertEquals("test", stack.peek())
        assertEquals(1, stack.size)
    }
}