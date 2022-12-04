import java.io.File

fun main() {
    var totalScore = 0
    val lines = readInput("input_day3")

    for (i in 0 until lines.size / 3) {
        totalScore += score2(lines[3 * i], lines[3 * i + 1], lines[3 * i + 2])
    }

    println(totalScore)
}

// Part 1
private fun score1(line: String): Int {
    val part1 = line.substring(0, line.length / 2).toSet()
    val part2 = line.substring(line.length / 2, line.length).toSet()

    val intersection = part1.intersect(part2)
    val score = intersection.sumOf {
        if (it.isUpperCase()) {
            it - 'A' + 27
        } else {
            it - 'a' + 1
        }
    }

    return score
}

// Part 2
private fun score2(line1: String, line2: String, line3: String): Int {
    val part1 = line1.toSet()
    val part2 = line2.toSet()
    val part3 = line3.toSet()

    val intersection = part1.intersect(part2).intersect(part3)

    val score = intersection.sumOf {
        if (it.isUpperCase()) {
            it - 'A' + 27
        } else {
            it - 'a' + 1
        }
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
