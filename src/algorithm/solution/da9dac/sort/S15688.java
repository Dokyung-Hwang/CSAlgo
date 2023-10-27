package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import algorithm.problem.baekjoon.sort.P15688;

public class S15688 implements P15688 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] count = new int[2000001];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int a : arr) {
			count[a + 1000000]++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				for (int j = 0; j < count[i]; j++) {
					sb.append((i - 1000000)).append("\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
