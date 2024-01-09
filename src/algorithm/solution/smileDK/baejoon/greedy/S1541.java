package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.greedy.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 55-50+40
public class S1541 implements P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정

        // token: [55, 50+40]
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        // 토큰 다 쓸 때 까지
        while (subtraction.hasMoreTokens()) {
            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
            // loop[1] = addition token [55]
            // loop[2] = addition tokens [50, 40]

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }
            // loop[1] = temp = 55
            // loop[2] = temp = 90

            // 첫 번째토큰인 경우 temp 값이 첫 번째 수가 됨
            if (max == Integer.MAX_VALUE) {
                max = temp;
            } else {
                max -= temp;
            }
            // max = 55
        }
        System.out.println(max);
    }
}
