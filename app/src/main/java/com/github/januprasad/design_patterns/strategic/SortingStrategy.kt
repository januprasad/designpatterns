package com.github.januprasad.design_patterns.strategic

/**
 * The Strategy Pattern is a behavioral
 * design pattern that enables selecting an algorithm's behavior at runtime.
 * It defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 *
 * Here’s a simple example of the Strategy
 * Pattern in Kotlin, where we’ll implement different sorting strategies.
 */
interface SortingStrategy {
    fun sort(data: IntArray): IntArray
}

class BubbleSort : SortingStrategy {
    override fun sort(data: IntArray): IntArray {
        val arr = data.copyOf()
        for (i in arr.indices) {
            for (j in 0 until arr.size - 1 - i) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }
}

class QuickSort : SortingStrategy {
    override fun sort(data: IntArray): IntArray {
        val arr = data.copyOf()
        quickSort(arr, 0, arr.size - 1)
        return arr
    }

    private fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(arr, low, high)
            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }
}
class Sorter(private var strategy: SortingStrategy) {
    fun setStrategy(strategy: SortingStrategy) {
        this.strategy = strategy
    }

    fun sort(data: IntArray): IntArray {
        return strategy.sort(data)
    }
}

fun main() {
    val data = intArrayOf(5, 2, 9, 1, 5, 6)

    val sorter = Sorter(BubbleSort())
    println("Bubble Sort: " +
            "${sorter.sort(data).map { 
                it.toString()
            }}")

//        sorter.setStrategy(QuickSort())
//                println("Quick Sort: ${sorter.sort(data.joinToString(", ").split(", ").map { it.toInt() }.toIntArray().contentToString()}")
}