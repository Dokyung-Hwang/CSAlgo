package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P7785;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class S7785 implements P7785 {
// TODO:
//  출입 기록 로그를 입력받아
//  현재 회사에 있는 모든 사람 사전 순의 역순으로 출력
//  (동명이인 X, 대소문자 구별)

// TODO:
//  입력받은 로그의 enter, leave를 기준으로
//  hashmap에 추가 or 삭제한 뒤
//  역순 정렬 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[1].equals("enter")) {
                hm.put(input[0], input[1]);
            } else {
                hm.remove(input[0]);
            }
        }

        List<String> keys = hm.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        keys.forEach(key -> {
            try {
                bw.write(key + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
    }
}
