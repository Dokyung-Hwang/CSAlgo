package algorithm.solution.smileDK.baejoon.hash;

import algorithm.problem.baekjoon.hash.P1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S1351 implements P1351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);    // A0 = 1



        System.out.println(map.get(n));



    }
}
