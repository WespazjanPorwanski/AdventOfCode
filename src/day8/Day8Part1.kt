package day8

import java.io.File
import java.io.FileNotFoundException
import java.util.*

val wide = 25
val tall = 6

fun main() {
    val input = readFile();
    val map = HashMap<String, Long>()
    for (layer in input) {
        map.put(layer, numberOfDigitInString(layer, "0"))
    }
    val sortedMap = map.toList().sortedBy { (_, value) -> value }.toMap()
    val result = sortedMap.entries.iterator().next();
    println(result.key)
    val noOfOne = numberOfDigitInString(result.key, "1")
    val noOfTwo = numberOfDigitInString(result.key, "2")
    println(noOfOne * noOfTwo)
}

private fun numberOfDigitInString(layer: String, digit: String): Long {
    return layer.split("").stream().filter { string -> string == digit }.count();
}

internal fun readFile(): List<String> {
    val input = LinkedList<String>()
    try {
        val file = File("src/day8/8.txt")
        val sc = Scanner(file)
        while (sc.hasNextLine()) {
            var string: String = sc.next()
            while (string.length != 0) {
                input.add(string.substring(0, tall * wide))
                string = string.substring(tall * wide)
            }
        }
        sc.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
    return input
}