package algorithm.solution.NtoZero_LST.boj.queue;

import algorithm.problem.baekjoon.queue.P2164;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class S2164 implements P2164 {
    /*
        시간 제한 2초, 메모리 제한 128MB
        - 1<= N <= 5 * 10^5
        먼저 들어온 수의 자리 이동이 잦다. => 큐, 덱 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        // 큐 사이즈가 1이 될 때까지 한 번은 버리고 한 번은 다시 마지막 요소로 포함한다.
        int turn = 0;
        while(queue.size()>1) {
            if(turn %2 == 0) {
                queue.poll();
            } else { // turn %2 == 1
                queue.add(queue.poll());
            }
            turn++;
        }

        // 마지막 하나 출력
        bw.write(String.valueOf(queue.poll()));
        bw.close();
    }
}
