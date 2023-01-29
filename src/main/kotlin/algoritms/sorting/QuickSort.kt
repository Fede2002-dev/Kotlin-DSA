package algoritms.sorting

private fun <T: Comparable<T>> quickSortHelper(array: Array<T>, left: Int, right: Int) {
    if (left < right) {
        val pivot = pivot(array, left, right)
        quickSortHelper(array, left, pivot - 1)
        quickSortHelper(array, pivot + 1, right)
    }
}

fun <T: Comparable<T>> Array<T>.quickSort() {
    quickSortHelper(this, 0, this.size-1)
}

private fun <T: Comparable<T>> pivot(theArray: Array<T>, pivotIndex: Int, endIndex: Int): Int {
    var sw = pivotIndex
    for (i in pivotIndex+1..endIndex) {
        if (theArray[pivotIndex] > theArray[i]) {
            sw++
            swap(theArray, sw, i)
        }
    }
    swap(theArray, pivotIndex, sw)
    return sw
}

private fun <T: Comparable<T>> swap(array: Array<T>, firstIndex: Int, secondIndex: Int) {
    val temp = array[firstIndex]
    array[firstIndex] = array[secondIndex]
    array[secondIndex] = temp
}

fun main() {
    val array = arrayOf(1,5,3,4,2)
    array.quickSort()
    array.forEach  (System.out::print)
}