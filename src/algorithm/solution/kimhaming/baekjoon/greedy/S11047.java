package algorithm.solution.kimhaming.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 동전 종류 개수
        int n = Integer.parseInt(st.nextToken());
        // 가치 총합
        int k = Integer.parseInt(st.nextToken());

        // 입력한 동전 종류 개수 n 크기의 배열 생성
        int[] coins = new int[n];
        // 최소 동전 개수를 저장할 변수
        int count = 0;

        // 한 줄씩 입력받아서 원소로 저장
        for (int i = 0; i < n; i++) {
            // 입력 엔터할 때마다 원소로 등록
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 위에서 입력받은 순서대로 인덱스에 저장됐으므로 큰 액수부터 순회하려면 오름차순으로 정렬하기
        Arrays.sort(coins);

        // 가장 큰 액수부터 시작하여 작은 액수까지 순회하기
        for (int i = n - 1; i >= 0; i--) {

            // 현재 사용한 동전 개수
            int currentCoin = k / coins[i];

            // 사용한 동전 개수 count에 누적
                count += currentCoin;
                // 마저 계산해야할 나머지 금액 k 알기
                k -= (currentCoin * coins[i]);
                // k가 다 사용될 때까지 반복문 반복
            // k원이 완성되면 반복문 종료
            if (k == 0) {
                    break;
            }
        }

        System.out.println(count);

        // K원에 따라 최솟값 출력된다.
        // 만들어둔 돈 단위 10종류 배열의 원소를 최소로 사용하여 K원을 만들 수 있는 최소 개수 구하기
    }
}
