import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class 이중우선순위큐테스트 {
    val operations = listOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")
    val result = intArrayOf(0,0)
    @Test
    fun solution() {
        var queue :ArrayDeque<Int> = ArrayDeque()

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
        var answer:IntArray = if(queue.isEmpty()) intArrayOf(0,0) else intArrayOf(queue.first(),queue.last())
        assertArrayEquals(result,answer)
    }
}