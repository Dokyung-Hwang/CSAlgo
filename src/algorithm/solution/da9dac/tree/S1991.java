package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.tree.P1991;

public class S1991 implements P1991 {

	private static int[] lc, rc;

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars;

		int n = Integer.parseInt(br.readLine());

		lc = new int[n + 1];
		rc = new int[n + 1];

		char c, l, r;

		for (int i = 1; i <= n; i++) {
			chars = br.readLine().toCharArray();

			c = chars[0];
			l = chars[2];
			r = chars[4];

			if (l != '.') lc[c - 'A' + 1] = l - 'A' + 1;
			if (r != '.') rc[c - 'A' + 1] = r - 'A' + 1;
		}

		pre(1);
		sb.append("\n");
		in(1);
		sb.append("\n");
		post(1);

		System.out.println(sb);
	}

	private static void pre(int cur) {
		sb.append((char)(cur + 'A' - 1));
		if (lc[cur] != 0) pre(lc[cur]);
		if (rc[cur] != 0) pre(rc[cur]);
	}

	private static void in(int cur) {
		if (lc[cur] != 0) in(lc[cur]);
		sb.append((char)(cur + 'A' - 1));
		if (rc[cur] != 0) in(rc[cur]);
	}

	private static void post(int cur) {
		if (lc[cur] != 0) post(lc[cur]);
		if (rc[cur] != 0) post(rc[cur]);
		sb.append((char)(cur + 'A' - 1));
	}
}
