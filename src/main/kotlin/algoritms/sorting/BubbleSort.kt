package algoritms.sorting

fun <T: Comparable<T>> Array<T>.bubbleSort() {
    for(i in 0 until size) {
        for (j in 0 until size-1){
            if(this[j] > this[j+1]) {
                val aux = this[j]
                this[j] = this[j+1]
                this[j+1] = aux
            }
        }
    }
}
