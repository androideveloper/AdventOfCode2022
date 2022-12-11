import java.io.File

fun main() {
    val lines = readInput("input_day10")

    val score = score1(lines)

    println(score)
}

// Part 1
private fun score1(lines: List<String>): Int {
    val cycles = IntArray(lines.size * 2)
    var current = 1
    cycles[1] = 1

    for (line in lines) {
        if (line == "noop") {
            cycles[current + 1] = cycles[current]
            current++
        } else {
            val number = line.split(" ")[1].toInt()
            cycles[current + 1] = cycles[current]
            cycles[current + 2] = cycles[current] + number
            current += 2
        }
    }

    val score = listOf(20, 60, 100, 140, 180, 220).sumOf { it * cycles[it] }

    return score
}

// Part 2


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
