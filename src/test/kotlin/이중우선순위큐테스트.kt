import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.ArrayDeque

class 이중우선순위큐테스트 {
    val operations = listOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")
    val result = intArrayOf(333,-45)
    @Test
    fun solution() {
        var queue : ArrayList<Int> = ArrayList()

        operations.forEach {
                operation ->
            val (command : String, number) = operation.split(" ")
            when(command){
                "I" ->{
                    queue.add(number.toInt())
                    queue.sort()
                }
                "D" ->
                    when(number){
                        "1" -> queue.removeLastOrNull()
                        "-1" -> queue.removeFirstOrNull()
                    }
            }
        }
        var answer:IntArray = if(queue.isEmpty()) intArrayOf(0,0) else intArrayOf(queue.last(),queue.first())
        assertArrayEquals(result,answer)
    }

    @Test
    fun solution2(){
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        var count = 0

        operations.map {
            it ->
            it.split(" ")
        }.forEach{
            (command,number) ->
            when(command){
                "I" -> {
                    val num = number.toInt()
                    minHeap.add(num)
                    maxHeap.add(num)
                    count++
                }
                "D" -> {
                    if(count == 0) return@forEach
                    count --

                    if(number == "1"){
                        if(maxHeap.isNotEmpty()){
                            minHeap.remove(maxHeap.peek())
                            maxHeap.poll()
                        }
                    }else{
                        if(minHeap.isNotEmpty()){
                            maxHeap.remove(minHeap.peek())
                            minHeap.poll()
                        }
                    }
                }
            }
        }

        val answer = if (count == 0) intArrayOf(0, 0) else intArrayOf(maxHeap.poll(), minHeap.poll())
        assertArrayEquals(result,answer)
    }
}