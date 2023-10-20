package algorithm.solution.NtoZero_LST.boj.stack;


import algorithm.problem.baejoon.stack.P10773;

import java.util.*;
import java.io.*;

public class S10773 implements P10773 {
    /*
        시간 제한 1초, 메모리 제한 256MB
        연산 K의 최대 값 10^5
        - 시간 복잡도 : NlogN 이하 권장
        - 자료 구조 : 모든 연산이 O(1)인 Stack 사용 권장. -> 최대 O(N)의 시간 복잡도를 가진다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) {
                // 정수가 0일 경우에는 지울 수 있는 수가 있음을 보장 ( <=> !stack.isEmpty())
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        for(int i : stack) {
            sum += i;
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
