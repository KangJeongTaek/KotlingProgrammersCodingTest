import org.junit.jupiter.api.Test
import java.util.*

class `보석 쇼핑` {

    val gems : Array<String> = arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")
    @Test
    fun solution() {
        val gemSet : Set<String> = gems.toSet()

        var start : Int = 0
        var end : Int = 0

        val hashMap : MutableMap<String, Int> = HashMap()

        var answer = intArrayOf(0, gems.size - 1)

        while(end < gems.size) {
            hashMap[gems[end]] = hashMap.getOrDefault(gems[end], 0) + 1
            end++

            while(hashMap.size == gemSet.size) {
                if(end - start < answer[1] - answer[0] + 1){
                    answer = intArrayOf(start ,end - 1)
                }
                hashMap[gems[start]] = hashMap[gems[start]]!! - 1
                if(hashMap[gems[start]] == 0){
                    hashMap.remove(gems[start])
                }
                start++
            }
        }

        println(answer.contentToString())
    }
}