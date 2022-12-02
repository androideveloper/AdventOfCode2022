import java.io.File

fun main() {
    var totalScore = 0
    val lines = readInput("input_day2")

    for (line in lines) {
        totalScore += score2(line)
    }

    // Part 1
    println(totalScore)
}

val points = mapOf(
    "X" to 1,
    "Y" to 2,
    "Z" to 3
)

// Part 1
fun score1(line : String) : Int {
    val (opponent, me) = line.split(" ")

    val winnerScore = when {
        opponent == "A" && me == "X" -> 3
        opponent == "A" && me == "Y" -> 6
        opponent == "A" && me == "Z" -> 0
        opponent == "B" && me == "X" -> 0
        opponent == "B" && me == "Y" -> 3
        opponent == "B" && me == "Z" -> 6
        opponent == "C" && me == "X" -> 6
        opponent == "C" && me == "Y" -> 0
        opponent == "C" && me == "Z" -> 3
        else -> 0
    }

    return winnerScore + points[me]!!
}

// Part 2
fun score2(line : String) : Int {
    val (opponent, result) = line.split(" ")

    val me = when {
        opponent == "A" && result == "X" -> "Z"
        opponent == "A" && result == "Y" -> "X"
        opponent == "A" && result == "Z" -> "Y"
        opponent == "B" && result == "X" -> "X"
        opponent == "B" && result == "Y" -> "Y"
        opponent == "B" && result == "Z" -> "Z"
        opponent == "C" && result == "X" -> "Y"
        opponent == "C" && result == "Y" -> "Z"
        opponent == "C" && result == "Z" -> "X"
        else -> 0
    }

    return score1("$opponent $me")
}

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readInput(name: String) = File("files", "$name.txt").readLines() // Reads lines from the given input txt file.
