package algoritms.sorting

fun <T: Comparable<T>> Array<T>.mergeSort(): Array<T> {
    if(this.size == 1) return this
    val middle = this.size/2
    var left: Array<T> = this.sliceArray(0 until middle)
    var right: Array<T> = this.sliceArray(middle until this.size)
    left = left.mergeSort()
    right = right.mergeSort()
    return merge(left, right)
}

private fun  <T: Comparable<T>> merge(arrayOne: Array<T>, arrayTwo: Array<T>): Array<T> {
    val array = arrayOne + arrayTwo
    var j = 0
    var k = 0
    for (index in array.indices) {
        when {
            j < arrayOne.size && k < arrayTwo.size -> {
                if (arrayOne[j] < arrayTwo[k]) array[index] = arrayOne[j++] else array[index] = arrayTwo[k++]
            }
            j < arrayOne.size -> array[index] = arrayOne[j++]
            k < arrayTwo.size -> array[index] = arrayTwo[k++]
        }
    }
    return array
}
