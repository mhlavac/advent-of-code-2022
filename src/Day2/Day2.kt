package Day2

import java.io.File

fun main() {
    val lines = File("src", "Day2/input.txt").readLines()
    var totalScore = 0

    lines.forEach {
        val (theirs, mine) = it.split(" ")
        val score = score(map(theirs), map(mine))
        totalScore += score
        println("$theirs $mine: $score")
    }

    println("Total Score: $totalScore")
}

fun score(theirs: String, mine:String): Int {
    var score = 0
    when (mine) {
        "Rock" -> score += 1 // Rock is 1 point
        "Paper" -> score += 2 // Paper is 2 points
        "Scissors" -> score += 3 // Scissors are 3 points
    }

    if (theirs == mine) {
        return score + 3 // Draw is 3 points
    }

    if (
        (theirs == "Rock" && mine == "Paper") || // A Rock is wrapped in a Y Paper
        (theirs == "Paper" && mine == "Scissors") || // B Paper is cut by Z scissors
        (theirs == "Scissors" && mine == "Rock")    // C Scissors is blunted by X Rock
    ) {
        return score + 6; // Win is 6 points
    }

    return score
}

fun map(move: String): String {
    when (move) {
        "A", "X" -> return "Rock"
        "B", "Y" -> return "Paper"
        "C", "Z" -> return "Scissors"
    }

    return ""
}
