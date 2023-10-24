package algorithm.solution.da9dac.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baejoon.backTracking.P15650;

public class S15650 implements P15650 {

	private static int n;
	private static int m;
	private static boolean[] isUsed = new boolean[9];
	private static int[] arr = new int[9];
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		func(0);

		System.out.println(sb);
	}

	private static void func(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int st = 1;
		if(k != 0) st = arr[k-1] + 1;

		for (int i = st; i <= n; i++) {
			if (!isUsed[i]) {
				arr[k] = i;
				isUsed[i] = true;
				func(k + 1);
				isUsed[i] = false;
			}
		}
	}
}
