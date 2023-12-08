package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P1620;

import java.io.*;
import java.util.HashMap;

public class S1620 implements P1620 {
// TODO:
//  포켓몬 갯수 N, 문제 개수 M이 주어질 때
//  입력받은 문제가 포켓몬 이름이라면 포켓몬 번호 출력,
//  입력받은 문제가 포켓몬 번호라면 포켓몬 이름 출력

// TODO:
//  포켓몬 번호를 key로 하는 map,
//  이름을 key로 하는 map을 만들어
//  문제에 따라 get해서 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<Integer, String> numberMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numberMap.put(i, name);
            nameMap.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            // 숫자라면
            if (Character.isDigit(problem.charAt(0))) {
                bw.write(numberMap.get(Integer.parseInt(problem)) + "\n");
            } else {
                bw.write(nameMap.get(problem) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
