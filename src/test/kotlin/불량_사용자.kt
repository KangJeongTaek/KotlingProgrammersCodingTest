import org.junit.jupiter.api.Test
import java.util.*

class 불량_사용자 {

    val user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id = arrayOf("fr*d*", "*rodo", "******", "******")

    val result = 3

    @Test
    fun solution(){
        val convertList = Array(banned_id.size){mutableListOf<String>()}
        for(i in banned_id.indices){
            val pattern = banned_id[i].replace("*",".")
            val regex = Regex("^$pattern$")
            for(j in user_id.indices)
                if(regex.matches(user_id[j])) convertList[i].add(user_id[j])
        }

        println(convertList.contentToString())

        val stack  = Stack<Pair<Int,Set<String>>>()

        val result : MutableSet<Set<String>> = mutableSetOf()

        stack.push(Pair(0, setOf()))

        while(stack.isNotEmpty()){
            val (depth, visited) = stack.pop()

            if(depth == convertList.size){
                result.add(visited)
                continue
            }

            for(user in convertList[depth]){
                if(user !in visited){
                    stack.push(Pair(depth + 1,  visited + user))
                }
            }
        }
    }




}