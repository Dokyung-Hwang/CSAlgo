package algorithm.solution.smileDK.baejoon.array;

import algorithm.problem.baekjoon.array.P3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/* TODO:
    Q.
    input: n(1<=n<=100,000), n개의 서로 다른 양의 정수 a1, a2, ..., an 수열(1 <= ai <= 1,000,000), x(1<=x<=2,000,000)
    output: ai + aj = x(1<=i<j<n)을 만족 하는 (ai, aj)쌍의 갯수
    S.
    1. BufferedReader로 n, 수열, x 입력받기
    2. 입력받은 수열 오름차순 정렬
    3. 투 포인터로 시작과 끝에서 시작하는 두 개의 포인터가 교차할 때까지 조건 검사 (ai + aj = x)
    4. 조건에 맞으면 count++;
    5. count 출력
 */

public class S3273 implements P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());


        int[] sequence = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            sequence[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(sequence);

        int count = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = sequence[start] + sequence[end];
            if (sum == x) count++;

            if (sum <= x) start++;
            else end--;
        }

        System.out.println(count);
    }
}
