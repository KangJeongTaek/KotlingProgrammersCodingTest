import org.junit.jupiter.api.Test

class 징검다리_건너기 {

    val stones :IntArray= intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
    val k : Int = 3
    val result : Int = 3

    @Test
    fun solution() {
        var answer = 0
        whileLoop@while(true){
            var jump = 0
            for(i in stones.indices){
                if(stones[i] == 0) {
                    jump++
                    if(jump >= k) break@whileLoop
                }else{
                    jump = 0
                }
            }

            for(i in stones.indices){
                if(stones[i] > 0) stones[i] --
            }
            answer++
        }

        println(answer)
    }
}