import org.junit.jupiter.api.*

class 불량_사용자 {

    val user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id = arrayOf("fr*d*", "*rodo", "******", "******")

    val result = 3

    @Test
    fun solution(){
        val convertMap = mutableMapOf<String, MutableList<String>>()
        for(i in banned_id.indices){
            val pattern = banned_id[i].replace("*",".")
            val regex = Regex("^$pattern$")
            for(j in user_id.indices)
                if(regex.matches(user_id[j])) convertMap.getOrPut(banned_id[i]) { mutableListOf() }.add(user_id[j])
        }


        for ((ban, list) in convertMap) {
            println("$ban => $list")
        }
    }
}