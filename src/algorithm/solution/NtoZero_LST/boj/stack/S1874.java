package algorithm.solution.NtoZero_LST.boj.stack;


import algorithm.problem.baejoon.stack.P1874;

import java.util.*;
import java.io.*;

public class S1874 implements P1874 {
    /*
        시간 제한 2초, 메모리 제한 128MB
        정수의 개수 N, 10^5
        시간 복잡도 NlogN 이하 권장
        - 자료 구조 : 스택 (LIFO)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int cursor = 0;
        for(int i=1; i<=N; i++) {
            int K = Integer.parseInt(br.readLine());
            while(cursor < K) {
                stack.add(++cursor);
                result.append("+\n");
            }
            while(!stack.isEmpty() && stack.peek()==K) {
                stack.pop();
                result.append("-\n");
            }

            if(!stack.isEmpty() && stack.peek() > K) {
                result.setLength(0);
                result.append("NO");
                break;
            }
        }

        System.out.println(result);

    }
}
/*
    stack peek() 사용에 주의해야 한다. stack이 비어 있다면 peek()은 예외를 발생 시킨다.
    deque의 pop()은 첫 번째 요소의 제거이다.
 */