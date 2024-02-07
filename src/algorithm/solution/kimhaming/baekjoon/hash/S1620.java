package algorithm.solution.kimhaming.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S1620 implements P1620 {
    // Todo:
    //  1. 입력 순서대로 1번부터 N번까지의 도감이 입력된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        // N 입력받을 문자의 갯수 -> 1부터 N까지
        for (int i = 0; i < N; i++) {
             String S = br.readLine();
             hash1.put(i, S);
             hash2.put(S, i);
        }

        // M 몇 번의 추가적인 문자열 입력을 처리할지
        for (int i = 0; i < M; i++) {
            String S = br.readLine();

            // S 문자열의 첫 번째 문자 확인하기 => 문자와 유니코드의 관계성 활용
            if (49 <= S.charAt(0) && S.charAt(0) <= 57) {
                sb.append(hash1.get(Integer.parseInt(S))).append("\n");
            } else {
                sb.append(hash2.get(S)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
