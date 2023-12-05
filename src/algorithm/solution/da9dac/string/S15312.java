package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.string.P15312;

public class S15312 implements P15312 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] strokes = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

		String boy = br.readLine();
		String girl = br.readLine();

		int length = boy.length();
		int idx = 0;

		int[] count = new int[length * 2];

		for (int i = 0; i < length; i++) {
			count[idx++] = strokes[boy.charAt(i) - 'A'];
			count[idx++] = strokes[girl.charAt(i) - 'A'];
		}

		int cur = length * 2 - 1;

		while (cur-- >= 2) {
			for (int i = 0; i < cur + 1; i++) count[i] = (count[i] + count[i + 1]) % 10;
		}

		System.out.println(count[0] + "" + count[1]);
	}
}
