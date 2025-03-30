import org.junit.jupiter.api.Test


class `단어 변환` {

    val begin = "hits"
    val target = "cog"
    val word = arrayOf("hot", "dot", "dog", "lot", "log", "cog")

    @Test
    fun solution(){
        var answer = 0
        if(target !in word) answer = 0

        val complStringList = mutableListOf<String>()
        val queue = ArrayDeque<Pair<String,Int>>()

        queue.add(Pair(begin, 0))

        while(!queue.isEmpty()) {
            var (word1,depth) = queue.removeFirst()

            if(word1 == target){
                answer = depth
                break
            }

            for(w in word){
                if(w !in complStringList && isConvert(word1,w)){
                    complStringList.add(w)
                    queue.add(Pair(w,depth + 1))
                }
            }
        }
        return
    }

    fun isConvert(begin:String,target:String) :Boolean{
        var result = 0
        for(i in 0 until begin.length){
            if(begin[i] == target[i]) result++
        }

        return result == 1
    }
}