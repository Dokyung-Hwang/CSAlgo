package algorithm.solution.NtoZero_LST.boj.linkedlist;


import algorithm.problem.baejoon.linkedList.P1158;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class S1158 implements P1158 {
    /*
        시간 제한 2초, 메모리 제한 256MB
        (1 ≤ K ≤ N ≤ 5,000 (=5*10^3))

        - 시간 복잡도 : N^2 이하의 알고리즘 채택
        - 자료 구조 : 원형 링크드 리스트 (각 노드가 다음을 가리키고 마지막 노드 다음은 다시 첫 노드를 가리키는 형태)
                     단, 자바 표준 라이브러리의 LinkedList는 이중 연결 리스트로, 원형 연결 리스트를 지원하지 않는다.
                     따라서 원형 연결 리스트를 직접 구현하거나, 별도의 인덱싱을 구현해야 한다.
                        (사실, 별도의 인덱싱을 구현한다면 자료 구조가 LinkedList일 필요도 없다.)
            - 예시로부터 인덱스 점화식 구하기
                1 2 3 4 5 6 7 -> 3 [2]
                1 2 4 5 6 7 -> 6 [4]
                1 2 4 5 7 -> 2 [1]
                1 4 5 7 -> 7 [3]
                1 4 5 -> 5 [2]
                1 4 -> 1 [0]
                4 -> 4 [0]
                인덱스는 0부터 시작하므로 제거할 첫 인덱스의 위치는 N-1 이다.
                커서(cursor) : 제거할 인덱스 위치, 첫 커서 = N-1
                커서 점화식 => (커서+K-1) % 사이즈 // 커서+K-1에서 -1의 이유는 리스트의 사이즈가 하나씩 줄어들기 때문에 커서의 위치도 한 칸 줄어들기 때문이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NAndKArr = br.readLine().split(" ");
        int N = Integer.valueOf(NAndKArr[0]);
        int K = Integer.valueOf(NAndKArr[1]);

        // 연결 리스트 (1~N 까지의 사람을 담는다.)
        List<Integer> list = new LinkedList();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        // 요세푸스 순열(정답 순열)을 담을 배열
        int[] answerArr = new int[N];

        // 조건: 리스트의 요소는 하나씩 제거 되어야 한다. cursor는 +K칸씩 이동 하지만 리스트 사이즈의 범위 안에서 순회해야 한다.
        int cursor = K-1; // 순회하기 위한 cursor, 인덱스는 0부터 시작하므로 첫 커서는 -1
        // 요세푸스 순열에 담길 인덱스
        int idx=0;
        while(list.size()>0) {
            answerArr[idx++] = list.remove(cursor); // 사이즈--
            // 탈출 조건: 리스트의 사이즈가 0이면 모듈러 연산 불가능
            if(list.isEmpty()) break;
            // 순회할 cursor, cursor+K-1의 이유는 직전에 요소가 제거 되었으므로 커서도 한 칸 줄어야 하기 때문이다.
            cursor = (cursor+K-1)%(list.size());
        }

        bw.write("<");
        for(int i=0; i<answerArr.length; i++) {
            bw.write(String.valueOf(answerArr[i]));
            if(i < answerArr.length-1) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.close();
    }
}

/*
다른 풀이
  1. ListIterator 사용 (Iterator가 소모 연산임을 반영한 풀이)
  2. cursor와 index 사용
*/
