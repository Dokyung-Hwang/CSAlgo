package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Todo
   Stair Rule
   1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
   2. 연속된 세 개의 계단을 모두 밟아서는 안된다. 단, 시작점은 계단에 포함되지 않는다.
   3. 마지막 도착 계단은 반드시 밟아야 한다.
   * Input
   첫 째줄에 계단의 개수, 둘 째줄 부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여있는 점수가 주어진다.
   계단의 개수는 300 이하의 자연수, 계단에 쓰여 있는 점수는 10,000 이하의 자연수
   * Output
   첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값
   * Table Definition
   d[i] = i번째 계단까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, 단 i번째 계단은 반드시 밟지 않을 계단으로 선택
   d[k] = min(d[k-2], d[k-3]) + s[k]
   d[1] = s[1], d[2]=s[2], d[3] = s[3]
   */


public class S2579 implements P2579 {

    private static final int[] d = new int[301];
    private static final int[] s = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairNums = Integer.parseInt(br.readLine());

        int total = 0;
        for (int i = 1; i <= stairNums; i++) {
            s[i] = Integer.parseInt(br.readLine());
            total += s[i];
        }

        if (stairNums <= 2) {
            System.out.println(total);
            return;
        }

        d[1] = s[1];
        d[2] = s[2];
        d[3] = s[3];

        for (int i = 4; i <= stairNums - 1; i++) {
            d[i] = Math.min(d[i-2], d[i-3]) + s[i];
        }

        System.out.println(total - Math.min(d[stairNums - 1], d[stairNums - 2]));
    }
}
