package Day3

import java.io.File
fun main() {
    val lines = File("src", "Day3/input.txt").readLines()
    var totalPriority = 0
    lines.chunked(3) { chunk ->
        var intersectingValues = chunk[0].toCharArray()
        chunk.forEach {
            intersectingValues = intersectingValues.intersect(it.toCharArray().toList()).toCharArray()
        }

        val chunkText = chunk.joinToString(":")
        val char = intersectingValues.first()
        val score = score(char)
        println("$chunkText: $char $score")

        totalPriority += score
    }

    println("Points: $totalPriority")
}
