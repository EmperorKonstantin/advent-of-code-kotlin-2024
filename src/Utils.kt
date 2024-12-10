import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * Reads lines from the given input txt file.
 */
fun readFile(file: String): List<String> {
    return try {
        Path("src/input/$file.txt").readText().trim().lines()
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        emptyList()
    }
}

// Function to parse two lists (left and right) from the input file
fun parseColumns(input: List<String>): Pair<List<Long>, List<Long>> {
    val (leftList, rightList) = input.map { line ->
        line.split(Regex("\\s+")).let {
            require(it.size == 2)
            it[0].toLong() to it[1].toLong()
        }
    }.unzip()

    return Pair(leftList, rightList)
}