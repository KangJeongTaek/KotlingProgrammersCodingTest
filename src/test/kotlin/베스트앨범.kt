import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Arrays
import java.util.TreeSet

class 베스트앨범 {

    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(500,600,150,800,2500)

    val result = intArrayOf(4,1,3,0)

    @Test
    fun solution(){
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
        val genresPlays : MutableList<Triple<String,Int,Int>> = mutableListOf()

        // Triple 만들고 groupBy 하기
        for(i in 0 until genres.size){
            genresPlays.add(Triple(genres[i] , plays[i], i))
        }

        val genresSorted = genresPlays.groupBy { it.first }.mapValues { it.value.sumOf { it.second } }.entries.sortedByDescending { it.value }.map { it.key }

        val answer = mutableListOf<Int>()

        for(genre in genresSorted){
            val songs = genresPlays
                .filter { it.first == genre }
                .sortedWith(compareByDescending<Triple<String,Int,Int>> { it.second }.thenBy { it.third })

            songs.take(2).map { it.third }.forEach {
                answer.add(it)
            }
        }

        assertArrayEquals(answer.toIntArray(), result)
    }
}