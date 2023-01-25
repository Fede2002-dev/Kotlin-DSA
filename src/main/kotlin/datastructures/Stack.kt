package datastructures

import java.util.EmptyStackException

class Stack<T> {
    var size: Int = 0
        private set
    var top: Node<T>? = null
        private set

    fun push(value: T) {
        val node = Node(value)
        node.next = top
        top = node
        size++
    }

    fun pop(): T {
        if (isEmpty()) throw EmptyStackException()
        val temp = top
        top = top?.next
        temp?.next = null
        size--
        return temp!!.value
    }

    fun peek(): T {
        if(isEmpty()) throw EmptyStackException()
        return top!!.value
    }

    fun isEmpty(): Boolean = top == null

    data class Node<S>(
        var value: S,
        var next: Node<S>? = null
    )
}