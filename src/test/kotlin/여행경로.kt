import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertContentEquals
import  kotlin.test.assertEquals

class 여행경로 {

    val tickets : Array<Array<String>> = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL","SFO")
    )

    val result : Array<String> = arrayOf("ICN", "ATL", "ICN", "SFO", "ATL", "SFO")

    @Test
    fun solution(){
        // DFS를 통해 우선 티켓의 정렬이 필요 출발지 -> 도착지 순

        //뒤에 작성할 stack을 후입선출이므로 reversed()를 해야 사전순으로 pop할 수 있다.
        val sortedTickets = tickets.sortedWith(
            compareBy({ it[0] },{ it[1] })
        ).reversed()

        val stack = Stack<Pair<List<String>,BooleanArray>>()

        // pair.first = 현재까지 저장한 경로,
        // pair.second = tickets 중의 몇 번째 인덱스를 방문했는가를 저장하기 위한
        stack.push(Pair(listOf("ICN"), BooleanArray(tickets.size)))

        while (!stack.empty()) {
            val (path,used) = stack.pop()

            if(path.size == tickets.size + 1){
                assertContentEquals(path.toTypedArray(),result)
                break
            }

            for (i in sortedTickets.indices) {
                if (!used[i] && path.last() == sortedTickets[i][0]) {
                    val newUsed = used.copyOf()
                    newUsed[i] = true
                    stack.push(Pair(path + sortedTickets[i][1], newUsed))
                }
            }
        }



    }
}