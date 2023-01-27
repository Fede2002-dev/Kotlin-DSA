package datastructures

class BinarySearchTree<T : Comparable<T>> {

    var root: Node<T>? = null
        private set

    fun add(value: T) {
        root = add(root, value)
    }

    private fun add(node: Node<T>?, value: T): Node<T> {
        if (node == null) return Node(value)
        if (value < node.value) {
            node.left = add(node.left, value)
        }
        if (node.value < value) {
            node.right = add(node.right, value)
        }
        return node
    }

    fun contains(value: T): Boolean = get(root, value) != null

    private fun get(node: Node<T>?, value: T): Node<T>? {
        if (node == null) return null
        if (node.value == value) return node

        return if (value < node.value) {
            get(node.left, value)
        } else {
            get(node.right, value)
        }
    }

    fun remove(value: T) {
        remove(root, value)
    }

    private fun remove(current: Node<T>?, value: T): Node<T>? {
        if (current == null) return null
        when {
            value < current.value -> {
                current.left = remove(current.left, value)
            }
            current.value < value -> {
                current.right = remove(current.right, value)
            }
            else -> {
                return if (current.right == null && current.left == null) {
                    null
                } else if (current.left == null) {
                    current.right
                } else if (current.right == null) {
                    current.left
                } else {
                    val minValue = minValue(current.right!!)
                    current.value = minValue
                    current.right = remove(current.right, minValue)
                    current
                }
            }
        }
        return current
    }

    fun minValue(node: Node<T>): T {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current.value
    }

    fun maxValue(node: Node<T>): T {
        var current = node
        while (current.right != null) {
            current = current.right!!
        }
        return current.value
    }

    data class Node<T>(
        var value: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    )
}
