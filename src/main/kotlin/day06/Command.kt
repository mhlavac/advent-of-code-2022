package day06

import com.github.ajalt.clikt.core.CliktCommand
import java.io.File

class Day06 : CliktCommand() {
    override fun run() {
        println("Day 6 - https://adventofcode.com/2022/day/6")
        val text = File("src", "main/kotlin/day06/input.txt").readText()
        val device = CommDevice()
        println("Part 1 (start-of-packet): " + device.findStartOfPacketMarker(text))
        println("Part 2 (start-of-message): " + device.findStartOfMessageMarker(text))
    }
}

class CommDevice {
    fun findStartOfPacketMarker(message: String): Int {
        return findStartOf(message, 4)
    }

    fun findStartOfMessageMarker(message: String): Int {
        return findStartOf(message, 14)
    }

    private fun findStartOf(message: String, slidingWindowSize: Int): Int {
        message.forEachIndexed { index, it ->
            val substr = message.substring(index, index + slidingWindowSize)
            val charArray = substr.toCharArray()
            if (charArray.distinct().size == slidingWindowSize) {
                return index + slidingWindowSize
            }
        }

        return 0
    }
}
