package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P17219;

import java.io.*;
import java.util.HashMap;

public class S17219 implements P17219 {
// TODO:
//  전체 사이트 개수 N, 비밀번호를 찾고자하는 사이트 개수 M을 입력받아
//  찾고자하는 사이트 주소의 비밀번호를 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] sitePassword = br.readLine().split(" ");
            hm.put(sitePassword[0], sitePassword[1]);
        }

        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            bw.write(hm.get(site) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
