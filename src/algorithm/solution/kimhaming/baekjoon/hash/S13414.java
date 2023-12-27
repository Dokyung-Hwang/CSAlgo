package algorithm.solution.kimhaming.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P13414;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;

public class S13414 implements P13414 {
    public static void main(String[] args) throws IOException {
        //  TODO: 수강신청에 성공한 인원 출력하기
        //   1. 기존에 있는 학번이면 빼서 맨 뒤에 다시 넣는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] S = br.readLine().split(" ");
        int k = Integer.parseInt(S[0]);
        int l = Integer.parseInt(S[1]);

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String num = br.readLine();
            if (set.contains(num)) set.remove(num);
            set.add(num);
        }

        for(String ret : set) {
            if (k <= 0)
                break;
            bw.write(ret);
            bw.write("\n");
            k--;
        }

        bw.flush();
        bw.close();
    }
}
