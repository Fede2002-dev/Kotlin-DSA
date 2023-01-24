package datastructures

class LinkedList<T> {

    /**
     * Data class that holds data and pointer to next piece of data
     */
    data class Node<S>(
        var value: S,
        var next: Node<S>? = null
    )

    var length = 0
        private set

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun addToFront(value: T): Boolean {
        val node = Node(value)
        node.next = head
        head = node
        tail = head ?: node
        length++
        return true
    }

    fun add(value: T): Boolean {
        tail?.let { it ->
            val node = Node(value)
            it.next = node
            this.tail = node
            length++
            return true
        } ?: return addToFront(value)
    }

    fun get(index: Int): T? {
        if(index < 0 || length < index) throw IndexOutOfBoundsException()
        var temp = head
        for (i in 0 until index) {
            temp = temp?.next
        }
        return temp?.value
    }

    private fun getNode(index: Int): Node<T>? {
        if(index < 0 || length < index) throw IndexOutOfBoundsException()
        var temp = head
        for (i in 0 until index) {
            temp = temp?.next
        }
        return temp
    }

    fun insertAt(index: Int, value: T): Boolean {
        if(index==0) return addToFront(value)
        if(index==length-1) return add(value)
        if(index > length-1) throw IndexOutOfBoundsException()
        getNode(index-1)?.let { previousNode ->
            val nodeToInsert = Node(value)
            nodeToInsert.next = previousNode.next
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
        prev?.next = nodeToRemove?.next
        length--
        return nodeToRemove
    }

    companion object {
        fun <T> fromArray(array: Array<T>): LinkedList<T> {
            val linkedList = LinkedList<T>()
            for(i in array.indices) {
                val value = array[i]
                linkedList.add(value)
            }
            return linkedList
        }
    }
}
