package day8

import java.io.File
import java.io.FileNotFoundException
import java.util.*

fun main() {
    val inputs = readFilePart2();
    val stringBuilder = StringBuilder();
    for (i in 0..wide * tall) {
        var digit = "2"
        for (input in inputs) {
            if (input[i] == "0" || input[i] == "1") {
                digit = input[i]
                break
            }
        }
        stringBuilder.append(digit)
    }

    var result = stringBuilder.toString().substring(1)
    for (i in 0 until tall) {
        var resString = result.substring(0, wide)
        resString = resString.replace("1", "X")
        resString = resString.replace("0", " ")
        println(resString)
        result = result.substring(wide)
    }
}

internal fun readFilePart2(): List<Array<String>> {
    val input = LinkedList<Array<String>>()
    try {
        val file = File("src/day8/8.txt")
        val sc = Scanner(file)
        while (sc.hasNextLine()) {
            var string: String = sc.next()
            while (string.length != 0) {
                input.add(string.substring(0, tall * wide).split("").toTypedArray())
                string = string.substring(tall * wide)
            }
        }
        sc.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
    return input
}