import java.io.File

fun main() {
    var totalScore = 0
    val lines = readInput("input_day6")

    for (line in lines) {
        totalScore += score2(line)
    }

    println(totalScore)
}

// Part 1
private fun score1(line: String): Int {
    val index = line
        .windowedSequence(size = 4, step = 1)
        .indexOfFirst {
            it.toSet().distinct().size == 4
        }

    return index + 4
}

// Part 2
private fun score2(line: String): Int {
    val index = line
        .windowedSequence(size = 14, step = 1)
        .indexOfFirst {
            it.toSet().distinct().size == 14
        }

    return index + 14
}


private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readInput(name: String) =
    File("files", "$name.txt").readLines() // Reads lines from the given input txt file.
