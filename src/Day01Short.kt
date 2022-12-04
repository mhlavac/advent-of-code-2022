// Day1.txt is expected as an input file
import java.io.File

fun main() {
    val elfs = File("src", "Day1.txt").readText().split("\n\n").map { elf ->
        elf.split("\n").sumOf { it.toIntOrNull() ?: 0 }
    }.sortedDescending()

    println("Max Calories: " + elfs.max())
    println("Sum of top 3 Calories: " + elfs.take(3).sum())
}
