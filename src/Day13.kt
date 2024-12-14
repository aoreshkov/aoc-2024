fun main() {

    fun getTokens(input: List<String>, day: Int) : Long {
        return """Button A: X(?<ax>[+,-]\d+), Y(?<ay>[+,-]\d+)
                |Button B: X(?<bx>[+,-]\d+), Y(?<by>[+,-]\d+)
                |Prize: X=(?<x>\d+), Y=(?<y>\d+)
            """
            .trimMargin()
            .toRegex()
            .findAll(input.joinToString("\n"))
            .sumOf {
                val (axStr, ayStr, bxStr, byStr, xStr, yStr) = it.destructured
                val ax = axStr.toLong()
                val ay = ayStr.toLong()
                val bx = bxStr.toLong()
                val by = byStr.toLong()
                if(ay * bx - ax * by == 0L) TODO()
                val x = xStr.toLong() + (day - 1) * 10000000000000
                val y = yStr.toLong() + (day - 1) * 10000000000000
                val a = (x * by - y * bx) / (ax * by - ay * bx)
                val b = (x * ay - y * ax) / (ay * bx - ax * by)
                if((a <= 100 && b <= 100 || day == 2) && x == a * ax + b * bx && y == a * ay + b * by) a * 3 + b
                else 0
            }
    }

    fun part1(input: List<String>): Long {
        return getTokens(input,1)
    }

    fun part2(input: List<String>): Long {
        return getTokens(input, 2)
    }

    val testInput = readInput("Day13_test")
    check(part1(testInput) == 480L)

    val input = readInput("Day13")
    part1(input).println()

    part2(testInput).println()

    part2(input).println()
}
