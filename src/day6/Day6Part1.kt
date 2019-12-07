package day6

import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val orbits = HashMap<String, Tree>()
    val distinctOrbits = HashSet<String>()
    val inputsList = readFile()
    for (input in inputsList) {
        val parameters = input.split(")");
        distinctOrbits.add(parameters[0]);
        distinctOrbits.add(parameters[1]);
    }

    distinctOrbits.stream().forEach { orb -> orbits.put(orb, Tree(orb)) }

    for (input in inputsList) {
        val parameters = input.split(")");
        orbits[parameters[1]]?.parent = orbits[parameters[0]];
    }

    var count = 0
    orbits.values.stream().forEach { o -> count += o.count() }
    print(count)

}

class Tree(name: String) {
    var name: String = name;
    var parent: Tree? = null;
    fun count(): Int {
        return if (parent == null) 0 else 1 + parent!!.count()
    }
}

internal fun readFile(): List<String> {
    val input = LinkedList<String>()
    try {
        val file = File("src/day6/6.txt")
        val sc = Scanner(file)
        while (sc.hasNextLine()) {
            val string: String = sc.next()
            input.add(string)
        }
        sc.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }

    return input
}

