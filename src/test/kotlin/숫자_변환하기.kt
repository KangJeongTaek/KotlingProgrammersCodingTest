import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class 숫자_변환하기 {

    val x :Int = 10
    val y :Int = 40
    val n :Int = 30
    val result :Int = 1
    @Test
    fun solution(){
        val queue : Queue<Int> = LinkedList()
        val booleanArray : BooleanArray= BooleanArray(y - -x)
        queue.add(x)
        booleanArray[x] = true
        var answer = 0
        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size){
                val curr :Int = queue.poll()
                if(curr == y) {
                    assertEquals(result,answer)
                    return
                }
                if(curr * 3 <= y && !booleanArray[curr * 3]){
                    booleanArray[curr * 3] = true
                    queue.add(curr * 3)
                }
                if(curr * 2 <= y && !booleanArray[curr * 2]){
                    booleanArray[curr * 2] = true
                    queue.add(curr * 2)
                }
                if(curr + n <= y && !booleanArray[curr + n]){
                    booleanArray[curr + n] = true
                    queue.add(curr + n)
                }
            }
            answer++
        }
        assertEquals(result, -1)
    }
}