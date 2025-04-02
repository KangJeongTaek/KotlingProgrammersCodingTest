package _JavaProgrammersCodingTest

import org.junit.jupiter.api.Test
import java.util.PriorityQueue
import java.util.Stack
import kotlin.test.assertEquals

//하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
// 이 문제에서는 우선순위 디스크 컨트롤러라는 가상의 장치를 이용한다고 가정합니다. 우선순위 디스크 컨트롤러는 다음과 같이 동작합니다.
//
//어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
//디스크 컨트롤러는 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서
// 꺼내서 하드디스크에 그 작업을 시킵니다. 이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
//하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
//하드디스크가 어떤 작업을 마치는 시점과 다른 작업 요청이 들어오는 시점이 겹친다면 하드디스크가 작업을 마치자마자 디스크 컨트롤러는
// 요청이 들어온 작업을 대기 큐에 저장한 뒤 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
// 또, 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작할 수 있습니다.
// 이 과정에서 걸리는 시간은 없다고 가정합니다.
//우선순위 디스크 컨트롤러에서 모든 요청 작업의 반환 시간의 평균은
// 8ms(= (3ms + 16ms + 5ms) / 3)가 됩니다.
//
//각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 정수 배열 jobs가 매개변수로 주어질 때,
// 우선순위 디스크 컨트롤러가 이 작업을 처리했을 때 모든 요청 작업의 반환 시간의 평균의 정수부분을
// return 하는 solution 함수를 작성해 주세요.
class 디스크컨트롤러 {
    var jobs: Array<IntArray> = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(3, 5))
    val result = 8

    @Test
    fun solution() {
        var totalWait = 0
        var time = 0
        var count = 0

        // 작업 대기 큐
        //first = 소요시간
        //second = 요청 시각
        // third 번호 (index + 1)
        val jobsQueue: PriorityQueue<Triple<Int, Int, Int>> = PriorityQueue<Triple<Int, Int, Int>>(
            compareBy<Triple<Int, Int, Int>> { it.second }
        )

        //first = 소요시간
        //second = 요청 시각
        // third 번호 (index + 1)
        // 작업 순서 큐
        val priortyQueue: PriorityQueue<Triple<Int, Int, Int>> = PriorityQueue<Triple<Int, Int, Int>>(
            compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenBy { it.third }
        )

        for ((i, array) in jobs.withIndex()) {
            jobsQueue.add(Triple(array[1], array[0], i + 1))
        }

        while (count < jobs.size) {
            while (jobsQueue.isNotEmpty() && jobsQueue.peek().second <= time)
                priortyQueue.add(jobsQueue.poll())

            if (priortyQueue.isNotEmpty()) {
                val job = priortyQueue.poll()
                time += job.first
                totalWait += time - job.second
                count++
            } else
                time++
        }
        var answer = totalWait / count

        assertEquals(result, answer)
    }
}