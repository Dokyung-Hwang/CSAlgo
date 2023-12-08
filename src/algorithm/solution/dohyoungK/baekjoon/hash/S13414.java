package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P13414;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class S13414 implements P13414 {
// TODO:
//  주어진 조건에 따라 수강 신청에 성공한 인원 출력
//  1. 수강 신청을 중복으로 한 경우 앞의 신청을 무시하고 뒤에 신청한 것으로 간주
//  2. 수강 신청이 끝나면 앞에서부터 인원 자르기

// TODO: *
//  LinkedHashMap으로 수강신청 순서를 기억하고
//  중복 신청이라면 이전 신청을 삭제하고 다시 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        // 순서 유지 위해 linkedHashMap
        HashMap<String, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            // 중복 수강 신청인 경우 이전 신청을 삭제하고 다시 저장 
            if (hm.getOrDefault(id, -1) != -1) {
                hm.remove(id);
            }
            hm.put(id, i);
        }

        List<String> keys = hm.keySet().stream().collect(Collectors.toList());
        // 수강 신청 제한 정원보다 수강 신청 성공한 학생수가 적을 경우 고려
        for (int i = 0; i < Math.min(K, keys.size()); i++) {
            bw.write(keys.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
