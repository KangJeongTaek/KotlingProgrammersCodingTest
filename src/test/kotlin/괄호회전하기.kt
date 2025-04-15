import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class 괄호회전하기 {

    val s = "[](){}"
    val result = 3
    @Test
    fun solution(){
        var count = 0
        for(i in s.indices){
            val rotated = (s + s).substring(i, i + s.length)
            val stack : Stack<Char> = Stack<Char>()
            val matching = mapOf(')' to '(', ']' to '[', '}' to '{')

            var valid = true
            for(ch in rotated){
                if(ch == '(' || ch == '[' || ch =='{'){
                    stack.push(ch)
                }else{
                    if(stack.isEmpty() || stack.peek() != matching[ch]){
                        valid = false
                        break
                    }
                    stack.pop()
                }
            }
            if(stack.isEmpty() && valid) count++
        }

        assertEquals(result, count)
    }
}