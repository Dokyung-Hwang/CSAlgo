package algorithm.solution.kimhaming.baekjoon.dequeue;

import algorithm.problem.baekjoon.deque.P10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S10866 implements P10866 {
    // https://velog.io/@haminggu/백준Java-10866번-덱
    /**
     * 덱은 스택과 큐를 합쳐놓은 것과 같이 볼 수 있습니다.
     * 앞, 뒤 방향으로 추가 및 삭제 모두 가능합니다.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            switch (S) {
                case "push_front" :
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if (deq.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deq.pollFirst() + "\n");
                    break;
                case "pop_back" :
                    if (deq.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deq.pollLast() + "\n");
                    break;
                case "size" :
                    sb.append(deq.size() + "\n");
                    break;
                case "empty" :
                    if (deq.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front" :
                    if (deq.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deq.peekFirst() + "\n");
                    break;
                case "back" :
                    if (deq.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deq.peekLast() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
