package Day3

import java.io.File
fun main() {
    val lines = File("src", "Day3/input.txt").readLines()
    var totalPriority = 0
    lines.forEach {
        val firstChars = it.substring(0, it.length/2).toCharArray()
        val secondChars = it.substring(it.length/2, it.length).toCharArray()

        // Get the character
        val char = firstChars.intersect(secondChars.toList()).first()
        val score = score(char)
        println("$it: $char $score")

        totalPriority += score
    }

    println("Points: $totalPriority")
}

fun score(char: Char): Int {
    if (char.code >= 97) {
        return char.code - 96
    }

    return char.code - 38
}
