package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P17478;

import java.io.*;

public class S17478 implements P17478 {
// TODO:
//  재귀 횟수 N을 입력받아
//  정해진 문자열을 횟수만큼 출력하기

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        write(N, sb);
        bw.flush();
        bw.close();
    }

    private static void write(int N, StringBuilder underbar) throws IOException {
        bw.write(underbar + "\"재귀함수가 뭔가요?\"\n");

        if (N == 0) {
            bw.write(underbar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            bw.write(underbar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            bw.write(underbar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            bw.write(underbar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            underbar.append("____");
            write(N - 1, underbar);
            underbar.delete(0, 4);
        }
        bw.write(underbar + "라고 답변하였지.\n");
    }
}
