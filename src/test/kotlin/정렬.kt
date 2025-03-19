import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class 정렬 {

    val citations = intArrayOf(4,0,6,1,5)
    val result = 3
    @Test
    fun solution()  {
        var answer = 0
        val sorted = citations.sorted()
        // i  = 인용된 횟수
        // candidate = 인용된 횟수의 논문을 포함한 보다 많이 인용된 논문의 갯수
        // 0 1 4 5 6
        run{
            sorted.forEachIndexed { index, i ->
                val candidate = sorted.size - index
                if (i >= candidate) {
                    answer =candidate
                    return@run
                }
                answer = candidate
            }
        }
        answer =  if (sorted.last() == 0) 0 else answer

        assertEquals(result,answer)
    }
}