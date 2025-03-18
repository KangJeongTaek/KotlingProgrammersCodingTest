import org.junit.jupiter.api.Test


class 하노이의탑 {
    val n : Int = 2

    @Test
    fun solution() {
        var answer = mutableListOf<IntArray>()
        val from :Int = 1
        val to : Int = 3

        move(n,from,to,answer)

        answer.toTypedArray()
    }

    fun move(n :Int, from:Int, to:Int, answer: MutableList<IntArray>){

        val aux : Int = 6 - from - to

        if(n > 1) move(n - 1 , from ,aux,answer)
        val addArray = intArrayOf(from,to)
        answer.add(addArray)

        if(n > 1) move(n - 1,aux,to,answer)
    }
}