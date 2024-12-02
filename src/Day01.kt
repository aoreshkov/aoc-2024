import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {

        val left = input.map { it.split(" ").first().toInt() }.sorted()
        val right = input.map { it.split(" ").last().toInt() }.sorted()

        return left.foldIndexed(0) { index, acc, i -> acc + (i - right[index]).absoluteValue }
    }

    fun part2(input: List<String>): Int {

        val left = input.map { it.split(" ").first().toInt() }
        val right = input.map { it.split(" ").last().toInt() }

        return left.fold(0) { sum, element -> sum + element * right.filter { it == element }.size }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    val input = readInput("Day01")
    part1(input).println()

    check(part2(testInput) == 31)

    part2(input).println()
}