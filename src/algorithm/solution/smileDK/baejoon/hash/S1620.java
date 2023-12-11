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

        HashMap<String, Integer> hashMap1 = new HashMap<>();        // name, number
        HashMap<Integer, String> hashMap2 = new HashMap<>();        // number, name

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            hashMap1.put(name, i + 1);
            hashMap2.put(i + 1, name);
        }


        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            String question = br.readLine();

            // 문제가 숫자 일 경우
            if (Character.isDigit(question.charAt(0))) {
                sb.append(hashMap2.get(Integer.parseInt(question))).append("\n");
            }
            // 문제가 문자일 경우
            else {
                sb.append(hashMap1.get(question)).append("\n");
            }
        }

        System.out.println(sb);

    }
}
