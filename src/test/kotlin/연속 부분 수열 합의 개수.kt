import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test

class `연속 부분 수열 합의 개수` {

    val elements = intArrayOf(7,9,1,1,4)
    val result = 18
    @Test
    fun solution(){
        var answer : Int = 0
        var doubleElements = elements + elements
        val sumSet = mutableSetOf<Int>()
        for( i in 1 ..elements.size){
            for(j in elements.indices){
                sumSet.add(doubleElements.slice(j until i + j).sum())
            }
        }
        println(sumSet.size)
    }
}