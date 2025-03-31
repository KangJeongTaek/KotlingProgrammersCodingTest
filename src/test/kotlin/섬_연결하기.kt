import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class 섬_연결하기 {

    val n : Int = 4
    val costs : Array<IntArray> = arrayOf(
        intArrayOf(0,1,1),
        intArrayOf(0,2,2),
        intArrayOf(1,2,5),
        intArrayOf(1,3,1),
        intArrayOf(2,3,8)
    )
    val result = 4

    @Test
    fun solution(){
        var answer = 0
        val priorityQueue = PriorityQueue<Triple<Int,Int,Int>>(
            compareBy { it.third }
        )

        val isVisit = mutableSetOf<Int>()

        // 시작 섬을 0번으로 설정
        isVisit.add(0)

        // 시작 섬에서 갈 수 있는 모든 간선 넣기
        for(cost in costs){
            if(cost[0] == 0 || cost[1] == 0){
                priorityQueue.add(Triple(cost[0],cost[1],cost[2]))
            }
        }

        while(isVisit.size < n && priorityQueue.isNotEmpty()){
            val (from, to ,cost) = priorityQueue.poll()

            val next = if(to !in isVisit) to else if (from !in isVisit) from else null

            if(next != null){
                isVisit.add(next)
                answer += cost

                for(edge in costs){
                    if((edge[0] == next && edge[1] !in isVisit) ||
                        edge[1] == next && edge[0] !in isVisit){
                        priorityQueue.add(Triple(edge[0],edge[1],edge[2]))
                    }
                }
            }
        }

        println(answer)
    }
}