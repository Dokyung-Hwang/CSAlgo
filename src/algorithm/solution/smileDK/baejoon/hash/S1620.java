package algorithm.solution.smileDK.baejoon.hash;

import algorithm.problem.baekjoon.hash.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1620 implements P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(br.readLine(), i + 1);
        }


        for (int j = 0; j < m; j++) {
            String question = br.readLine();

            // 문제가 문자열 일 경우
            if (question.matches("[a-zA-Z]+")) {
                System.out.println(hashMap.get(question));

            }
            // 문제가 숫자일 경우
            else {
                System.out.println(hashMap.get(question));
            }
        }

    }
}
