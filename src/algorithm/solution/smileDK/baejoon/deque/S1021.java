package algorithm.solution.smileDK.baejoon.deque;

import algorithm.problem.baekjoon.deque.P1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S1021 implements P1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] select = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            select[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(select[i]);
            int halfIdx;

            if(deque.size() % 2 == 0) {
                halfIdx = deque.size() / 2 - 1;
            }
            else {
                halfIdx = deque.size() / 2;
            }


            // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if(targetIdx <= halfIdx) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
                for(int j = 0; j < targetIdx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                for(int j = 0; j < deque.size() - targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }

            }
            deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
        }

        System.out.println(count);
    }
}
