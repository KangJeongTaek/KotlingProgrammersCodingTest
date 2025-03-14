import org.junit.jupiter.api.Test
import java.util.ArrayList
import kotlin.test.assertEquals

/* 깊이/너비 우선 탐색(DFS/BFS) 난이도 Lv. 3*/
class NetworkTest {
//    네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
//    예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때
//    컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
//
//    컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
    val n :Int = 3
    val computers = arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,1), intArrayOf(0,1,1))
    val result = 2


    @Test
    fun networkTest(){
//    우선 컴퓨터의 array를 그려보자
//     1, 1, 0
//     1, 1, 1
//     0, 1, 1

//     이미 연결이 된 컴퓨터는 찾지 않고, 새로운 연결이 된 경우에만 카운트를 하나 씩 올리면 되지 않을까?
        var answer : Int = 0
//     노드를 일단 반복해야겠지?
//     이 노드가 새로운 노드인지는 어떻게 알지?
//     새로운 노드인지를 확인할 공간이 필요하다.
        val isChecked = BooleanArray(n)
//     노드를 계속해서 이어서 탐색해야한다. 따라서 잇는 노드를 담는 공간이 필요하다.
        val nodeArray = ArrayList<Int>()
//      n 만큼 반복해서
        for( i in 0 until n) {
            //체크 되지 않았다면 안을 계속해서 탐색 해봐야겠지?
            if (!isChecked[i]) {
                //현재 탐색하는 노드를 저장
                nodeArray.add(i)
                isChecked[i] = true
                answer ++

                //현재 탐색하는 노드를 기준으로 안을 계속 돌아봐야겠지?
                while(nodeArray.isNotEmpty()){
                    //탐색을 시작했으므로 탐색하려는 노드에서 삭제
                    val startNode = nodeArray.removeFirst()
                    for(j in 0 until n) {
                        //isChecked[j]가 없으면 무한 반복 발생! 자기 자신이 들어갈 수 있으므로
                        if(computers[startNode][j] == 1 && !isChecked[j]){
                            //탐색해야하는 노드에 추가해야겠지?
                            nodeArray.add(j)
                            isChecked[j] = true
                        }
                    }
                }

            }
        }
        assertEquals(result, answer)
    }
}