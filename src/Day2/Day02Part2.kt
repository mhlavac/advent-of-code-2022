package Day2

import java.io.File


fun main() {
    val lines = File("src", "Day2/input.txt").readLines()
    var totalScore = 0

    lines.forEach {
        val (theirs, result) = it.split(" ")
        val score = score(map(theirs), decideWhatToPlay(map(theirs), result))
        totalScore += score
        println("$theirs $result: $score")
    }

    println("Total Score: $totalScore")
}

fun decideWhatToPlay(theirs: String, result:String): String {
    val play = when (result) {
        "X" -> "loose"
        "Y" -> "draw"
        else -> "win"
    }

    if (play == "draw") {
        return theirs
    }

    if (theirs == "Rock") {
        if (play == "loose") {
            return "Scissors"
        }
        if (play == "win") {
            return "Paper"
        }
    }

    if (theirs == "Paper") {
        if (play == "loose") {
            return "Rock"
        }
        if (play == "win") {
            return "Scissors"
        }
    }

    if (play == "loose") {
        return "Paper"
    }

    return "Rock"
}
