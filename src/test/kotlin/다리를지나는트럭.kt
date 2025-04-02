import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

//트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
// 다리에는 트럭이 최대 bridge_length 대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
// 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
//
//예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
// 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

class 다리를지나는트럭 {

//fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray)
//2	10	[7,4,5,6]	8
    val bridge_length : Int = 2
    val weight : Int = 10
    val truck_weights :IntArray = intArrayOf(7,4,5,6)
    val result = 8

    @Test
    fun solution(){
        var count = 0
        val queue : Queue<Int> = LinkedList()
        val bridge : Queue<Int> = LinkedList()
        var currWeight : Int = 0
        for(element in truck_weights){
            queue.add(element)
        }
        repeat(bridge_length){bridge.add(0)}
        // 잘 못 생각하고 있었다. bridge_length는 도로의 넓이가 아닌 길이이다.

        while(queue.isNotEmpty() || currWeight > 0){
            count ++

            currWeight -= bridge.poll()
            if(queue.isNotEmpty() && currWeight + queue.peek() <= weight){
                val nextTruck = queue.poll()
                bridge.add(nextTruck)
                currWeight += nextTruck;
            }else{
                bridge.add(0)
            }
        }
        println(count)
    }
}