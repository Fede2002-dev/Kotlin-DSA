package datastructures

class Queue<T> {

    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    var length = 0
        private set

    fun enqueue(value: T) {
        val node = Node(value)
        front = front ?: node
        rear?.next = node
        rear = node
        length++
    }

    fun dequeue(): T {
        if (isEmpty()) throw NullPointerException("Empty queue")
        val temp = front
        front = front?.next
        length--
        return temp!!.value
    }

    fun peek(): T {
        if (isEmpty()) throw NullPointerException("Empty queue")
        return front!!.value
    }

    fun rear(): T {
        if (isEmpty()) throw NullPointerException("Empty queue")
        return rear!!.value
    }

    fun isEmpty(): Boolean = length == 0

    data class Node<V>(
        var value: V,
        var next: Node<V>? = null
    )
}