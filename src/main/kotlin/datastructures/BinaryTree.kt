package datastructures

class BinaryTree<T> {

    private var root: Node<T>? = null

    fun root(): T? = root?.data

    fun height(): Int = height(root)

    fun size(): Int = size(root)

    private fun size(node: Node<T>?): Int {
        var size = 1
        if (node?.left != null) {
            size += size(node.left)
        }
        if (node?.right != null) {
            size += size(node.right)
        }
        return size
    }

    private fun height(node: Node<T>?): Int {
        val left = if (node?.left == null) 0 else height(node.left)
        val right = if (node?.right == null) 0 else height(node.right)
        return maxOf(left, right) + 1
    }

    fun add(value: T) {
        root?.let {
            add(it, value)
        } ?: run { root = Node(value) }
    }

    private fun add(node: Node<T>, value: T) {
        val queue = Queue<Node<T>>()
        queue.enqueue(node)
        while (!queue.isEmpty()) {
            val current = queue.dequeue()
            when {
                current.left == null -> {
                    current.left = Node(value)
                    return
                }
                current.right == null -> {
                    current.right = Node(value)
                    return
                }
                else -> {
                    queue.enqueue(current.left!!)
                    queue.enqueue(current.right!!)
                }
            }
        }
    }

    data class Node<T>(
        var data: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null,
    )
}
