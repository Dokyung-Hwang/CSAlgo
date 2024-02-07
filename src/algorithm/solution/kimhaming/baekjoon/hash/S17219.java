package algorithm.solution.kimhaming.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P17219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class S17219 implements P17219 {
    public static void main(String[] args) throws IOException {
        //  Todo: 메모장에서 비밀번호를 찾아주는 프로그램 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str1 = br.readLine().split(" ");

        HashMap<String, String> hashMap = new HashMap<>();

        int N = Integer.parseInt(str1[0]);
        int M = Integer.parseInt(str1[1]);

        while(N-->0) {
            String[] str2 = br.readLine().split(" ");

            hashMap.put(str2[0], str2[1]);
        }
        while(M-->0) {
            String search = br.readLine();

            bw.write(hashMap.get(search) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
