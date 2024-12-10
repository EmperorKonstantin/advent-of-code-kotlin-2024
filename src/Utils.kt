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
fun parseColumns(input: List<String>): Pair<List<Int>, List<Int>> {
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    // Process each line, splitting columns by three spaces
    input.forEach { line ->
        val columns = line.split("   ").map { it.trim() }

        if (columns.size == 2) { // Ensure there are exactly two columns
            try {
                leftList.add(columns[0].toInt())  // Parse first column into the left list
                rightList.add(columns[1].toInt()) // Parse second column into the right list
            } catch (e: NumberFormatException) {
                println("Error parsing line: $line - ${e.message}")
            }
        } else {
            println("Skipping invalid line: $line")
        }
    }

    return Pair(leftList, rightList)
}