package datastructures

import kotlin.math.abs

class HashTable<K, V>(private val size: Int = 16) {

    private val dataArray = arrayOfNulls<Node<K,V>>(size)

    fun put(key: K, value: V) {
        val position = hash(key)
        var temp = dataArray[position]
        while (temp != null) {
            if(temp.key == key) {
                temp.value = value
                return
            }
            if(temp.next == null) {
                temp.next = Node(key, value)
                return
            }
            temp = temp.next
        }
        dataArray[position] = Node(key,value)
    }

    fun get(key: K): V? {
        val position = hash(key)
        var temp = dataArray[position]
        while (temp != null) {
            if(temp.key == key) return temp.value
            temp = temp.next
        }
        return null
    }

    fun remove(key: K): V? {
        val position = hash(key)
        var temp = dataArray[position]
        if(temp?.key == key) {
            dataArray[position] = null
            return temp?.value
        }
        else {
            while (temp?.next != null) {
                val next = temp.next
                if(next?.key == key) {
                    temp.next = next?.next
                    return next?.value
                }
            }
        }
        return null
    }

    private fun hash(key: K): Int = (abs(key.hashCode()) % size)

    data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K,V>? = null
    )
}
