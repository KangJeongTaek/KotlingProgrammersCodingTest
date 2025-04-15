import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test
import java.util.*


class `타겟 넘버` {

    val numbers : IntArray = intArrayOf(4,1,2,1)
    val target : Int = 4
    val result :Int = 2


    @Test
    fun solution(){
        // first 현재까지 넣은 숫자 second 방문했는지 여부를 찾기 위한 것(몇 번째 순서)
        val stack : Stack<Pair<List<Int>, Int>> = Stack<Pair<List<Int>,Int>>()
        var answer = 0
        stack.push(Pair(listOf(numbers[0]),0))
        stack.push(Pair(listOf(-numbers[0]),0))

        while(!stack.isEmpty()){
            val curr = stack.pop()
            if(curr.first.sum() == target && curr.second == numbers.size - 1) {
                answer ++
                continue
            }

            val nextIndex = curr.second + 1
            if(nextIndex <numbers.size){
                stack.push(Pair(curr.first + numbers[nextIndex],nextIndex))
                stack.push(Pair(curr.first + (-numbers[nextIndex]),nextIndex))
            }
        }
        println("answer = ${answer}")

    }


}