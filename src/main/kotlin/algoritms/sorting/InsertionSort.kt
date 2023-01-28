package algoritms.sorting

fun <T: Comparable<T>> Array<T>.insertionSort() {
    for (i in 1 until size) {
        var j = i-1
        while(0 <= j && this[j+1] < this[j]) {
            val aux = this[j]
            this[j] = this[j+1]
            this[j+1] = aux
            j--
        }
    }
}
