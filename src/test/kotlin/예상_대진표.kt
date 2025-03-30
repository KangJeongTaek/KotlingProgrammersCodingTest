import org.junit.jupiter.api.Test

class 예상_대진표 {

    val n = 8
    var a = 4
    var b = 7

    //실패
    @Test
    fun solution(){
        var answer = 1
        while(Math.abs(a - b) != 1){
            a = Math.ceil(a / 2.0).toInt()
            b = Math.ceil(b / 2.0).toInt()
            answer++
        }
        print(answer)
    }

    @Test
    fun solution2(){
        var answer = 0
        while(a != b){
            a = (a + 1) / 2
            b = (b + 1) / 2
            answer++
        }
    }
}