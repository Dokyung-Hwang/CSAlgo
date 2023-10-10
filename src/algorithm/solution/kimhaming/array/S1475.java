package algorithm.solution.kimhaming.array;

import algorithm.problem.array.P1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1475 implements P1475 {
    // https://velog.io/@haminggu/백준Java-1475번-방-번호-s39n4csn
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int n = Integer.parseInt(N);
        if (n < 1 || n > 1000000) {
            System.out.println("N은 주어진 조건에 따라서 1 미만, 1,000,000 초과의 수는 입력될 수 없습니다.");
            return;
        }
        int[] numSet = new int[10];  // N 에 출현하는 0 ~ 9까지의 숫자의 갯수를 저장할 배열

        for (int i = 0; i < N.length(); i++) {
            numSet[N.charAt(i) - '0']++;    // N 에 출현하는 숫자의 갯수를 저장
        }
        // 6과 9에 대한 경우의 수 구하기
        int sixAndNine = (numSet[6] + numSet[9] + 1) / 2;   // 6이 3개 9가 2개일 때, 총 3세트가 필요하다. -> (5 + 1) / 2

        // 나머지 숫자에 대한 경우의 수 구하기
        int maxSet = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) { // 6과 9가 들어가는 세트 수는 제외하고
                // 최대 세트수만 필요하기 때문에, 방번호에 가장 여러번 사용된 숫자에 대한 세트수를 maxSet에 저장
                maxSet = Math.max(maxSet, numSet[i]);
            }
        }

        System.out.println(Math.max(maxSet, sixAndNine));
    }
}
