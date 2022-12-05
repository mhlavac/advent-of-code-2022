package Day5

import java.io.File
import java.util.regex.Pattern

fun main() {
    val lines = File("src", "Day5/input.txt").readLines()
    val stacks = ArrayList<ArrayDeque<Char>>()

    for (i in 0 until ((lines[0].length  + 1) / 3) + 1) {
        stacks.add(ArrayDeque())
    }

    println("Stack detected: " + stacks.size)

    var endOfStacksIndex = 0

    lines.forEachIndexed { lineIndex, line ->
        if (line.trim() == "") {
            endOfStacksIndex = lineIndex
            return@forEachIndexed
        }

        line.chunked(4).forEachIndexed { index, stack ->
            if (stack[0] == '[') { // Character found in stack
                stacks[index].addLast(stack[1])
            }
        }
    }


    val pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)")
    for(index in endOfStacksIndex + 1 until lines.size){
        val line = lines[index]
        val matcher = pattern.matcher(line)
        matcher.find()
        val numberOfBoxes = matcher.group(1).toInt()
        val from = matcher.group(2).toInt()
        val to = matcher.group(3).toInt()

        var movedContainers = stacks[from - 1].subList(0, numberOfBoxes)
        stacks[to - 1].addAll(0, movedContainers)

        for (i in 1 ..numberOfBoxes) {
            stacks[from - 1].removeFirst()
        }
    }

    var result = ""
    stacks.forEach {
        if (it.size > 0) {
            result += it.first()
        }
    }

    println("Result: $result")
}
