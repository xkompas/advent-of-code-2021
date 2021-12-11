fun main() {

    fun getRate(codes: Map<String, Int>, size: Int, selectMax: Boolean): Int {
        val bits = codes.keys.first().length

        return (0 until bits).map { i ->
            val zeros = codes.filterKeys { it[i] == '0' }.values.sum()
            val ones = size - zeros
            val zeroMax = zeros > ones
            if ((selectMax && zeroMax) || !(selectMax || zeroMax)) '0' else '1'
        }.joinToString(separator = "").toInt(2)
    }

    fun part1(input: List<String>): Int {
        val size = input.size

        val codes = input.groupBy { it }.map { (k, v) -> k to v.size }.toMap()

        val gamma = getRate(codes, size, true)
        val epsilon = getRate(codes, size, false)

        return gamma * epsilon
    }

    fun getRating(theCodes: Map<String, Int>, selectMax: Boolean): Int {
        var codes = theCodes

        val bits = codes.keys.first().length

        for (i in 0 until bits) {
            if (codes.size < 2) {
                break
            }

            val zeros = codes.filterKeys { it[i] == '0' }.values.sum()
            val ones = codes.filterKeys { it[i] == '1' }.values.sum()
            val zeroMax = zeros > ones

            val selectedBit = if (selectMax == zeroMax) '0' else '1'

            codes = codes.filterKeys { it[i] == selectedBit }
        }

        return codes.toList().first().first.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val codes = input.groupBy { it }.map { (k, v) -> k to v.size }.toMap()

        val oxygenRating = getRating(codes, true)
        val co2Rating = getRating(codes,false)

        return oxygenRating * co2Rating
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
