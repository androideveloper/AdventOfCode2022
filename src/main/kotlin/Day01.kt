import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main() {
    val file = File("files/input_day1.txt")
    val calories = mutableListOf<Int>()
    var sum = 0
    try {
        BufferedReader(FileReader(file)).use { reader ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                if (line.isNullOrEmpty()) {
                    calories.add(sum)
                    sum = 0
                } else {
                    sum += line!!.toInt()
                }
            }

            if (sum != 0) {
                calories.add(sum)
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    // Part 1
//    println(calories.max())

    // Part 2
    val top3Sum = calories.
        sortedByDescending { it }
        .take(3)
        .sum()
    println(top3Sum)
}

// TODO check my Klarna laptop key setup and copy here

//fun solve(testIndex: Int, n: Int, array : MutableList<Int>) {
//    var cost = 0
//
//    for (i in 0 until n - 1) {
//        val subList = array.subList(i, n)
//        val j = array.indexOf(subList.min())
//        cost += j - i + 1
//        array.subList(i, j + 1).reverse()
//    }
//
//    println("Case #$testIndex: $cost")
//}

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readInput(name: String) = File("files", "$name.txt").readLines() // Reads lines from the given input txt file.
