import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue
import kotlin.test.assertEquals

class 프로세스 {

    val priorities : IntArray = intArrayOf(1,1,9,1,1,1)
    val location : Int = 0
    val result = 1

    @Test
    fun solution(){
        var findPair : Pair<Int, Boolean> = Pair(0,false)
        val queue: Queue<Pair<Int, Boolean>> = LinkedList(
            priorities.mapIndexed { index, i ->
                i to (index == location)
            }
        )

        var executionCounter = 0

        while(!queue.isEmpty()) {
            val curr = queue.poll()
            val hasHigherPriority = queue.any { it.first > curr.first }

            if(hasHigherPriority) {
                queue.add(curr)
            }else{
                executionCounter++
                if(curr.second) {
                    println(executionCounter)
                    return
                }
            }
        }

        println(queue.size - queue.indexOf(findPair))

    }
}