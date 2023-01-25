package datastructures

class DoublyLinkedList<T> {

    data class Node<U>(
        var value: U,
        var next: Node<U>? = null,
        var prev: Node<U>? = null
    )

    var length = 0
        private set

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun addToFront(value: T): Boolean {
        val node = Node(value)
        head?.prev = node
        node.next = head
        head = node
        tail = head ?: node
        length++
        return true
    }

    fun add(value: T): Boolean {
        tail?.let { it ->
            val node = Node(value)
            node.prev = tail
            it.next = node
            this.tail = node
            length++
            return true
        } ?: return addToFront(value)
    }

    fun get(index: Int): T? {
        if(index < 0 || length < index) throw IndexOutOfBoundsException()
        var temp = head

        if(index <= length/2)  {
            for (i in 0 until index) {
                temp = temp?.next
            }
        } else {
            temp = tail
            for (i in length downTo index) {
                temp = temp?.prev
            }
        }
        return temp?.value
    }

    private fun getNode(index: Int): Node<T>? {
        if(index < 0 || length < index) throw IndexOutOfBoundsException()
        var temp = head
        if(index <= length/2)  {
            for (i in 0 until index) {
                temp = temp?.next
            }
        } else {
            temp = tail
            for (i in length downTo index) {
                temp = temp?.prev
            }
        }
        return temp
    }

    fun insertAt(index: Int, value: T): Boolean {
        if(index==0) return addToFront(value)
        if(index==length-1) return add(value)
        if(index > length-1) throw IndexOutOfBoundsException()
        getNode(index-1)?.let { previousNode ->
            val nodeToInsert = Node(value)
            val currentNode = previousNode.next
            currentNode?.prev = nodeToInsert
            nodeToInsert.next = previousNode.next
            nodeToInsert.prev = previousNode
            previousNode.next = nodeToInsert
            length++
            return true
        } ?: return false
    }

    fun removeFront(): Node<T>? {
        val temp = head
        head?.next?.let {
            this.head = it
            temp?.next = null
        } ?: run {
            tail = null
            head = null
        }
        length--
        return temp
    }

    fun removeLast(): Node<T>? {
        val temp = tail
        getNode(length-2)?.let {
            it.next = null
            tail = it
        } ?: return null
        length--
        return temp
    }

    fun removeAt(index: Int): Node<T>? {
        if(index==0) return removeFront()
        if(index==length-1) return removeLast()
        val prev = getNode(index-1)
        val nodeToRemove = prev?.next
        val next = nodeToRemove?.next
        prev?.next = next
        next?.prev = prev
        length--
        return nodeToRemove
    }

    fun traverseForward() {
        var temp = head
        while (temp != null) {
            print("${temp.value} ")
            temp = temp.next
        }
    }

    fun traverseBackward() {
        var temp = tail
        while (temp != null) {
            print("${temp.value} ")
            temp = temp.prev
        }
    }

    companion object {
        fun <T> fromArray(array: Array<T>): DoublyLinkedList<T> {
            val doublyLinkedList = DoublyLinkedList<T>()
            for(i in array.indices) {
                val value = array[i]
                doublyLinkedList.add(value)
            }
            return doublyLinkedList
        }
    }
}
