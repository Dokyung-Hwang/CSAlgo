package algorithm.solution.smileDK.baejoon.recursion;

import algorithm.problem.baekjoon.recursion.P17478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S17478 implements P17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(n, "");

    }

    public static void recursion(int n, String underline) {
        if (n == 0) {
            System.out.println(
                    underline + "\"재귀함수가 뭔가요?\"\n" +
                    underline + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" +
                    underline + "라고 답변하였지.");
            return ;
        }

        System.out.println(
                underline + "\"재귀함수가 뭔가요?\"\n" +
                underline + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                underline + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                underline + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        recursion(n - 1, underline + "_".repeat(4));
        System.out.println(underline + "라고 답변하였지.");
    }
}
