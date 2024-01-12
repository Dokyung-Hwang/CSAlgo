package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.greedy.P2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Memo.
    Input: n(1<=n<=1,000,000), 두 점의 위치 x, y(-1,000,000,000 <= x < y <= 1,000,000,000)
    output: 그은 선의 총 길이
    선이 그어질 수 있는 경우
    1. 현재 긋는 선이 이전 선에 완벽하게 포함되는 경우(continue)
    2. 현재 선이 이전 선의 일부만 포함되는 경우(총길이 += 현재 선의 끝 점 - 이전 선의 끝 점)
    3. 이전 선과 현재 선이 겹치지 않는 경우(총길이 += 현재 선의 끝점 - 현재 선의 시작 점)
*/
/* Review.
    문제를 보자마자 BOJ P1931 문제와 비슷하다고 느꼈다.
    P1931 문제를 풀지 않고 이번 문제를 풀었다면 꽤나 오랫동안 생각했을 것 같다.
    그리디 문제인 것 같으면 테스트 케이스를 먼저 정렬해보고 직접 손으로 그리면서 생각해보면 좋을 것 같다.
    처음 Comparator 를 접했을 땐 어렵고 적용하기 힘들었는데 지금은 어느정도 이해하고 적용할 수 있게 되었다.
*/


public class S2170 implements P2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // position[n][0]: 선의 시작 점
        // position[n][1]: 선의 끝 점

        int[][] position = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        // Todo: 선의 시작 점을 기준으로 position 배열 오름 차순 정렬(시작 점이 같을 경우, 끝 점을 기준으로 오름차순 정렬)
        Arrays.sort(position, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });


        int start = position[0][0];
        int end = position[0][1];
        int totalLength = end - start;

        for (int i = 1; i < n; i++) {
            // 현재 선이 이전 선에 완벽히 포함된 경우
            if (start <= position[i][0] && position[i][1] <= end) {
                continue;
            }
            // 현재 선이 이전 선의 일부만 포함된 경우
            else if (position[i][0] < end) {
                totalLength += position[i][1] - end;
            }
            // 현재 선이 이전 선에 포함되지 않았을 경우
            else {
                totalLength += position[i][1] - position[i][0];
            }

            // Todo: update point(start, end)
            start = position[i][0];
            end = position[i][1];
        }

        System.out.println(totalLength);
    }
}
