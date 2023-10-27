package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.recursion.P17478;

public class S17478 implements P17478 {
	// https://da9dac.tistory.com/201

	private static int n = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

		func(0);
	}

	private static void func(int k) {
		print(k, "\"재귀함수가 뭔가요?\"");

		if (k == n) {
			print(k, "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			print(k, "라고 답변하였지.");
			return;
		}

		print(k, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		print(k, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		print(k, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		func(k + 1);
		print(k, "라고 답변하였지.");
	}

	private static void print(int k, String x) {
		for (int i = 0; i < k; i++) {
			System.out.print("____");
		}

		System.out.println(x);
	}
}
