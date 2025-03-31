import org.junit.jupiter.api.Test

class 징검다리_건너기 {

    val stones :IntArray= intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
    val k : Int = 3
    val result : Int = 3

    @Test
    fun solution() {
        var left = 1
        var right = 200000000
        var answer = 0

        while (left <= right) {
            val middle = (left + right) / 2

            if(canCross(stones,middle,k)){
                answer = middle
                left = middle+ 1
            }else{
                right = middle - 1
            }
        }

        println("answer = $answer")

    }


    fun canCross(stones:IntArray,person : Int, k : Int) : Boolean {
        var jump = 0
        for(i in stones.indices){
            if(stones[i] < person){
                jump ++
                if(jump >= k ) return false
            }else{
                jump = 0
            }
        }

        return true
    }

    @Test
    fun solution2(){
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
        println("answer = $answer")
    }

}