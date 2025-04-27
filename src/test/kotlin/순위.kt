import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals


class 순위 {

    val n :Int= 5
    val results : Array<IntArray> =
        arrayOf(
        intArrayOf(4,3),
        intArrayOf(4,2),
        intArrayOf(3,2),
        intArrayOf(1,2),
        intArrayOf(2,5)
    )
    val result = 2
    @Test
    fun solution(){
        var answer = 0
        val wins : MutableList<MutableList<Int>> = MutableList(n){mutableListOf<Int>()}
        val loses : MutableList<MutableList<Int>>  = MutableList(n){mutableListOf<Int>()}
        for(result in results){
            val win = result[0]
            val lose = result[1]
            wins[win - 1].add(lose - 1)
            loses[lose - 1].add(win - 1)
        }

        fun bfsCount(start : Int, graph : List<List<Int>>) : Int{
            val visited = BooleanArray(n)
            val q : Stack<Int> = Stack<Int>()
            visited[start] = true
            q.add(start)
            var count = 0

            while(q.isNotEmpty()) {
                val cur = q.pop()
                for(nxt in graph[cur]){
                    if(!visited[nxt]){
                        visited[nxt] = true
                        q.add(nxt)
                        count++
                    }
                }
            }
            return count
        }

        for( i in 0 until n){
            val winCount = bfsCount(i,wins)
            val loseCount = bfsCount(i,loses)
            if(winCount + loseCount == n - 1){
                answer ++
            }
        }

        assertEquals(answer, result)
    }
}