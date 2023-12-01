package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P15312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S15312 implements P15312 {
// TODO:
//  영어 이름 2개를 입력받아 이름 궁합 결과 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 알파벳 획수
        int[] strokes = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        String aName = br.readLine();
        String bName = br.readLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < aName.length() + bName.length(); i++) {
            int index = 0;
            if (i % 2 == 0) {
                index = aName.charAt(i / 2) - 'A';
            } else {
                index = bName.charAt(i / 2) - 'A';
            }

            result.append(strokes[index]);
        }

        while (result.length() != 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < result.length() - 1; i++) {
                String sum = String.valueOf(Integer.parseInt(String.valueOf(result.charAt(i))) + Integer.parseInt(String.valueOf(result.charAt(i + 1))));
                next.append(sum.charAt(sum.length() - 1));
            }
            result = next;
        }

        System.out.println(result);
    }
}
