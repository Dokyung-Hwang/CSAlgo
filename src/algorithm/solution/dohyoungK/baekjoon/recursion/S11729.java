package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P11729;

import java.io.*;

public class S11729 implements P11729 {
// TODO:
//  원판 개수 N을 입력받아 하노이 탑에서의
//  원판 이동과정과 최소 이동횟수 출력

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2, N) - 1) + "\n");

        hanoi(N, 1, 2, 3);

        bw.flush();
        bw.close();
    }


//    start : 출발지
//    mid : 옮기기 위해 거쳐가는 장소
//    to : 목적지
    private static void hanoi(int N, int start, int mid, int to) throws IOException {
        if (N == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }

        hanoi(N - 1, start, to, mid);
        bw.write(start + " " + to + "\n");
        hanoi(N - 1, mid, start, to);
    }
}
