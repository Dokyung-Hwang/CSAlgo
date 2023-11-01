package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P6603;

public class S6603 implements P6603 {
	// https://da9dac.tistory.com/222

	private static StringBuilder sb;
	private static int n;
	private static int[] arr;
	private static int[] lottoNumbers = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			}

			arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			sb = new StringBuilder();

			lotto(0, 0);

			bw.write(sb.toString());
			bw.write("\n");
		}

		bw.flush();
	}

	private static void lotto(int size, int start) {
		if (size == 6) {
			for (int lottoNumber : lottoNumbers) {
				sb.append(lottoNumber).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
				lottoNumbers[size] = arr[i];
				lotto(size + 1, i + 1);
		}
	}
}
