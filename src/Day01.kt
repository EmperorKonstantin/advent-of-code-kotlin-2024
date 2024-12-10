// Function to pair up two lists, calculate distances, and return the total distance
fun pairAndCalculate(left: List<Int>, right: List<Int>): Int {
    val sortedLeft = left.sorted()
    val sortedRight = right.sorted()

    // Ensure both lists have the same size
    require(sortedLeft.size == sortedRight.size) { "Both lists must have the same size." }

    // Calculate the total distance by pairing up elements in sorted order
    return sortedLeft.zip(sortedRight) { a, b -> kotlin.math.abs(a - b) }.sum()
}


fun main() {
    val inputFile = "Day01" // Input file path

    // Read the input file
    val input = readFile(inputFile)

    // Parse two columns into two lists (left and right)
    val (leftList, rightList) = parseColumns(input)

    // Calculate the total distance by pairing up the lists
    val totalDistance = pairAndCalculate(leftList, rightList)

    // Print the result
    println("Total Distance: $totalDistance")
}
