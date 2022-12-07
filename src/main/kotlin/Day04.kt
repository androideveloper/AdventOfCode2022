import java.io.File

fun main() {
    var totalScore = 0
    val lines = readInput("input_day4")

    for (line in lines) {
        totalScore += score2(line)
    }

    println(totalScore)
}

// Part 1
private fun score1(line: String): Int {
    val (s1,e1,s2,e2) = line.split("[-,]".toRegex()).map { it.toInt() }

    val score = when {
        s1 <= s2 && e1 >= e2 -> 1
        s2 <= s1 && e2 >= e1 -> 1
        else -> 0
    }

    return score
}

// Part 2
private fun score2(line: String): Int {
    val (s1,e1,s2,e2) = line.split("[-,]".toRegex()).map { it.toInt() }

    val score = when {
        s1 <= e2 && s2 <= e1 -> 1
        else -> 0
    }

    return score
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
