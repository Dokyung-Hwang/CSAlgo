package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import algorithm.problem.baejoon.sort.P11728;

public class S11728 implements P11728 {
	// https://da9dac.tistory.com/195

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");

		int[] A = new int[n];
		int[] B = new int[m];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(input1[i]);
		}

		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(input2[i]);
		}

		int aIdx = 0;
		int bIdx = 0;

		for (int i = 0; i < n + m; i++) {
			if (aIdx == n) {
				sb.append(B[bIdx++]).append(" ");
			} else if (bIdx == m) {
				sb.append(A[aIdx++]).append(" ");
			} else if (A[aIdx] >= B[bIdx]) {
				sb.append(B[bIdx++]).append(" ");
			} else {
				sb.append(A[aIdx++]).append(" ");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
