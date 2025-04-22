import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class 행렬의_곱셈 {

    val arr1 : Array<IntArray> = arrayOf(intArrayOf(1,4), intArrayOf(3,2), intArrayOf(4,1))
    val arr2 : Array<IntArray> = arrayOf(intArrayOf(3,3), intArrayOf(3,3))


    @Test
    fun solution(){
//        [1,4]
//        [3,2]
//        [4,1]

//        [3,3]
//        [3,3]
        val answer = mutableListOf<IntArray>()
        for(i in arr1.indices){
            val row = IntArray(arr2[0].size)
            for(j in arr2[0].indices){
                var sum = 0
                for(k in arr1[0].indices){
                    sum += arr1[i][k] * arr2[k][j]
                }
                row[j] = sum
            }
            answer += row
        }
        answer.toTypedArray()
        println("answer = ${answer}")
    }

}