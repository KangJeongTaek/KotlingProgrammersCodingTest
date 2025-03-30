import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class 가장_먼_노드 {

    val n = 6
    val vertex = arrayOf(
        intArrayOf(3, 6),
        intArrayOf(4, 3),
        intArrayOf(3, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(5, 2)
    )

    val result = 3

    @Test
    fun solution(){
        // 그래프 추가
        val graph = Array(n + 1){ mutableListOf<Int>() }
        for((a, b ) in vertex){
            graph[a].add(b)
            graph[b].add(a)
        }

        val distance = Array(n + 1){-1} // -1 방문 안 함.
        val queue : Queue<Int> = LinkedList()

        distance[1] = 0
        queue.add(1)

        while(!queue.isEmpty()){
            val curr = queue.poll()
            for(neighbor in graph[curr]){
                if(distance[neighbor] == -1){
                    distance[neighbor] = distance[curr] + 1
                    queue.add(neighbor)
                }
            }
        }

        val maxDistance = distance.maxOrNull() ?: 0
        assertEquals(result, distance.count{it == maxDistance })
    }
}