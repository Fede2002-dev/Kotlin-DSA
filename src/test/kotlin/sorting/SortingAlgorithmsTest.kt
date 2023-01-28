package sorting

import algoritms.sorting.bubbleSort
import algoritms.sorting.insertionSort
import algoritms.sorting.mergeSort
import algoritms.sorting.selectionSort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SortingAlgorithmsTest {

    private val disorderedArray = arrayOf(1,2,3,4,5,6,7,8,9,10)
    private val orderedArray = arrayOf(1,2,3,4,5,6,7,8,9,10)

    @BeforeEach
    internal fun setUp() {
        disorderedArray.shuffle()
    }

    @Test
    fun bubbleSort() {
        disorderedArray.bubbleSort()
        assertArrayEquals(orderedArray, disorderedArray)
    }

    @Test
    fun insertionSort() {
        disorderedArray.insertionSort()
        assertArrayEquals(orderedArray, disorderedArray)
    }

    @Test
    fun selectionSort() {
        disorderedArray.selectionSort()
        assertArrayEquals(orderedArray, disorderedArray)
    }

    @Test
    fun mergeSort() {
        assertArrayEquals(orderedArray, disorderedArray.mergeSort())
    }
}