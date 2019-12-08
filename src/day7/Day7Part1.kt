package day7

fun main() {
    val intSequence = intArrayOf(0, 1, 2, 3, 4);
    val intcodeComputer = IntcodeComputer();
    var result = 0;
    val distinctPermutationList = permute(intSequence.toMutableList()).distinct()
    for (perm in distinctPermutationList) {
        var res = 0;
        for (char in perm) {
            res = intcodeComputer.start(Integer.valueOf(char), res);
        }
        if (res > result) {
            result = res
        };
    }
    println(result)
}

fun <String> permute(list: List<String>): List<List<String>> {
    if (list.size == 1) return listOf(list)
    val perms = mutableListOf<List<String>>()
    val sub = list[0]
    for (perm in permute(list.drop(1)))
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, sub)
            perms.add(newPerm)
        }
    return perms
}