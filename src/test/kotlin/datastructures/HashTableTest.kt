package datastructures

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class HashTableTest {
    @Test
    fun `put with key should add value to hashtable`() {
        // Given
        val hashTable = HashTable<String, String>()
        // When
        hashTable.put("key", "value")
        // Then
        assertEquals("value", hashTable.get("key"))
    }

    @Test
    fun `put with existing key should update value`() {
        // Given
        val hashTable = HashTable<String,String>()
        hashTable.put("key", "value")
        // When
        hashTable.put("key", "valueUpdated")
        // Then
        assertEquals("valueUpdated", hashTable.get("key"))
    }

    @Test
    fun `remove should remove item from hashmap`() {
        // Given
        val hashTable = HashTable<String,String>()
        hashTable.put("key", "value")
        // When
        hashTable.remove("key")
        // Then
        assertNull(hashTable.get("key"))
    }
}