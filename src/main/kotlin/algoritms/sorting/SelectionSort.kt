package algoritms.sorting

fun <T: Comparable<T>> Array<T>.selectionSort() {
    for(i in 0 until size) {
        var minIndex = i
        for (j in i+1 until size) {
            if(this[j] < this[minIndex]) {
                minIndex = j
            }
        }
        val aux = this[i]
        this[i] = this[minIndex]
        this[minIndex] = aux
    }
}
