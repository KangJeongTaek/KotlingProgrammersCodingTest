import java.util.Stack
import kotlin.test.Test
import kotlin.test.assertContentEquals

class 기능개발 {

    //    val progresses = intArrayOf(95,90,99,99,80,99)
//    val speeds = intArrayOf(1,1,1,1,1,1)
//    val result = intArrayOf(1,3,2)
    val progress = intArrayOf(93,30,55)
    val speeds = intArrayOf(1,30,5)
    val result = intArrayOf(2,1)
    @Test
    fun solution() {
        val pairList : ArrayList<Pair<Int,Int>> = ArrayList<Pair<Int,Int>>()

        val size : Int = progress.size

        var answer = mutableListOf<Int>()

        for(i in 0 until size) {
            var compl : Int = progress[i]
            var day : Int = 0
            while(compl < 100){
                compl += speeds[i]
                day++
            }
            pairList.add(i to day)
        }
        println(pairList.toString())

        while(pairList.isNotEmpty()){
            val comparePair = pairList.removeFirst()
            var answerCount = 1
            while (pairList.isNotEmpty() && comparePair.second > pairList[0].second){
                answerCount++
                pairList.removeFirst()
            }
            answer.add(answerCount)
        }
        assertContentEquals(result,answer.toIntArray())
    }
}