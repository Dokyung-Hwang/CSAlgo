package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.sort.P2910;

import java.io.*;
import java.util.*;

public class S2910 implements P2910 {
// TODO:
//  N개의 알파벳을 입력받아 조건에 맞춰 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<String> input = new HashSet<>();

        for (int i = 0; i < N; i++) {
            input.add(br.readLine());
        }

        List<String> words = new ArrayList<>(input);
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) return -1;
                else if (o1.length() > o2.length()) return 1;
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        words.forEach(word -> {
            try {
                bw.write(word + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
    }
}
