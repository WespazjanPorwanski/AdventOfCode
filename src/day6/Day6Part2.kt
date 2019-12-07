package day6

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

    var you = orbits["YOU"]
    var san = orbits["SAN"]

    var count = 0
    while (you?.parent != san?.parent) {
        if (you?.count()!! >= san?.count()!!) you = you.parent else san = san.parent
        count++
    }
    println(count)
}

