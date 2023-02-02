package algs.strings

class MakingAnagrams {

    fun makeAnagram(a: String, b: String): Int {
        // Write your code here
        val aSorted = a.toCharArray().toMutableList()
        val bSorted = b.toCharArray().toMutableList()
        var count = 0

        for(indexA in aSorted.indices) {
            if (bSorted.indexOf(aSorted[indexA]) != -1) {
                bSorted.remove(aSorted[indexA])
            } else count++
        }

        count += bSorted.size

        return count
    }


}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = MakingAnagrams().makeAnagram(a, b)

    println(res)
}
