fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0

        input.forEach {
            val arr = it.split(" ")
            val cmd = arr[0]
            val arg = arr[1].toInt()

            when (cmd) {
                "forward" -> x += arg
                "down" -> y += arg
                "up" -> y -= arg
            }
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0

        input.forEach {
            val arr = it.split(" ")
            val cmd = arr[0]
            val arg = arr[1].toInt()

            when (cmd) {
                "forward" -> {
                    x += arg
                    y += aim * arg
                }
                "down" -> aim += arg
                "up" -> aim -= arg
            }
        }

        return x * y
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
