package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P2250;

public class S2250 implements P2250 {
	// https://da9dac.tistory.com/309

	private static int idx = 1;
	private static int height;
	private static int[] p, lc, rc;
	private static int[][] width;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int c, l, r;

		p = new int[n + 1];
		lc = new int[n + 1];
		rc = new int[n + 1];
		width = new int[n + 1][2];

		Arrays.fill(p, -1);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			lc[c] = l;
			rc[c] = r;
			if (l != -1) p[l] = c;
			if (r != -1) p[r] = c;
		}

		int root = 0;

		for (int i = 1; i <= n; i++) {
			if (p[i] == -1) {
				root = i;
				break;
			}
		}

		in(root, 1);

		int maxDepth = 1;
		int maxWidth = 1;

		for (int i = 2; i <= height; i++) {
			int mw = Math.abs(width[i][0] - width[i][1]) + 1;
			if (width[i][0] * width[i][1] == 0) mw = 1;
			if (mw > maxWidth) {
				maxDepth = i;
				maxWidth = mw;
			}
		}

		System.out.println(maxDepth + " " + maxWidth);
	}

	private static void in(int cur, int d) {
		if (lc[cur] != -1) in(lc[cur], d + 1);
		height = Math.max(d, height);
		if (width[d][0] == 0) width[d][0] = idx++;
		else width[d][1] = idx++;
		if (rc[cur] != -1) in(rc[cur], d + 1);
	}
}
