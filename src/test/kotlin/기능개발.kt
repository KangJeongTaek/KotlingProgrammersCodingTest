import java.util.*
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

class 기능개발 {

//    val progresses = intArrayOf(95,90,99,99,80,99)
//    val speeds = intArrayOf(1,1,1,1,1,1)
//    val result = intArrayOf(1,3,2)
    val progress = intArrayOf(93,30,55)
    val speeds = intArrayOf(1,30,5)
    val result = intArrayOf(2,1)
    @Test
    fun solution() {
        val queue : Queue<Int> = LinkedList()
        val answer = mutableListOf<Int>()

        for( i in 0 until progress.size){
            val days = Math.ceil((100 - progress[i]).toDouble() / speeds[i]).toInt()
            queue.add(days)
        }

        while(!queue.isEmpty()){
            var count = 1
            val compareDay = queue.poll()

            while(queue.isNotEmpty() && compareDay >= queue.peek()){
                count++
                queue.poll()
            }
            answer.add(count)
        }

        assertContentEquals(result,answer.toIntArray())
    }
}