import kotlin.math.abs

fun main() {
    fun part1(leftList: List<Int>, rightList: List<Int>): Int {
        return leftList.sorted().zip(rightList.sorted()).sumOf { (left, right) ->
            val diff = abs(left - right)
            diff
        }
    }

    fun part2(leftList: List<Int>, rightList: List<Int>): Int {
        return leftList.sumOf { left ->
            val count = rightList.count { it == left }
            count * left
        }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    val (testLeftList, testRightList) = pair(testInput)
    check(part1(testLeftList, testRightList) == 2378066)
    check(part2(testLeftList, testRightList) == 18934359)


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")

    val (leftList, rightList) = pair(input)
    part1(leftList, rightList).println()
    part2(leftList, rightList).println()
}

private fun pair(input: List<String>) = input.map { line ->
    val parts = line.trim().split("\\s+".toRegex()) // Mehrfachleerzeichen behandeln
    parts[0].toInt() to parts[1].toInt()
}.unzip()
