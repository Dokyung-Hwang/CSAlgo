package algorithm.solution.da9dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2000002];
		int max = -1111111;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num + 1000001]++;
			max = Math.max(num, max);
		}

		for (int i = 1; i <= max + 1000001; i++) {
			int x = arr[i];
			if (x != 0) {
				for (int j = 0; j < x; j++) {
					sb.append(i - 1000001).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
