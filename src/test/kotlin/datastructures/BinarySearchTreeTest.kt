package datastructures

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertEquals

internal class BinarySearchTreeTest {

    private lateinit var tree: BinarySearchTree<Int>

    @BeforeEach
    fun setUp() {
        tree = BinarySearchTree()
        tree.add(10)
        tree.add(5)
        tree.add(15)
        tree.add(14)
        tree.add(20)
        tree.add(18)
        tree.add(21)
    }

    @Test
    fun add() {
        // When
        tree.add(30)
        // Then
        assertTrue(tree.contains(30))
        assertEquals(30, tree.maxValue(tree.root!!))
    }

    @Test
    fun contains() {
        assertTrue(tree.contains(18))
    }

    @Test
    fun remove() {
        // When
        tree.remove(15)
        // Then
        assertFalse(tree.contains(15))
    }

    @Test
    fun minValue() {
        assertEquals(5, tree.minValue(tree.root!!))
    }

    @Test
    fun maxValue() {
        assertEquals(21, tree.maxValue(tree.root!!))
    }
}