package datastructures

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach

internal class BinaryTreeTest {

    private lateinit var binaryTree: BinaryTree<Int>

    @BeforeEach
    internal fun setUp() {
        binaryTree = BinaryTree()
        binaryTree.add(1)
        binaryTree.add(2)
    }

    @Test
    fun root() {
        assertEquals(1, binaryTree.root())
    }

    @Test
    fun height() {
        assertEquals(2, binaryTree.height())
    }

    @Test
    fun size() {
        assertEquals(2, binaryTree.size())
    }

    @Test
    fun add() {
        // Given
        binaryTree.add(3)
        // Then
        assertEquals(3, binaryTree.size())
    }
}