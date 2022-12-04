// Day1.txt is expected as an input file

fun main() {
    val input = readInput("Day1")

    var caloriesPerElf = getCaloriesPerElf(input)

    println("Max Calories: " + caloriesPerElf[0])
    println("Sum of top 3 Calories: " + caloriesPerElf.take(3).sum())
}

private fun getCaloriesPerElf(input: List<String>): ArrayList<Int> {
    var caloriesPerElf = ArrayList<Int>()
    var currentCalories = 0

    input.forEach {
        if (it == "") {
            caloriesPerElf.add(currentCalories)
            currentCalories = 0
            return@forEach
        }

        currentCalories += it.toInt()
    }

    caloriesPerElf.sortDescending()

    return caloriesPerElf
}
