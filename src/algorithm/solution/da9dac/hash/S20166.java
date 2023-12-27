package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.hash.P20166;

public class S20166 implements P20166 {
	// https://da9dac.tistory.com/261

	private static int n;
	private static int m;
	private static int min = Integer.MAX_VALUE;
	private static int max = 0;

	private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	private static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	private static char[][] world;
	private static char[] chars;
	private static boolean[][] isUsed;

	private static Map<String, Integer> wordCount = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		world = new char[n][m];
		isUsed = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			world[i] = br.readLine().toCharArray();
		}

		String[] favorites = new String[k];

		for (int i = 0; i < k; i++) {
			String word = br.readLine();
			favorites[i] = word;
			max = Math.max(word.length(), max);
			min = Math.min(word.length(), min);
		}

		chars = new char[max];

		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				if (isUsed[i][j]) continue;
				isUsed[i][j] = true;
				chars[0] = world[i][j];
				makeWord(1, i, j);
				isUsed[i][j] = false;
			}
		}

		for (String favorite : favorites) {
			Integer count = wordCount.get(favorite);
			sb.append(count != null ? count : 0).append("\n");
		}

		System.out.println(sb);
	}

	private static void makeWord(int size, int x, int y) {
		if (size >= min) {
			String word = new String(Arrays.copyOfRange(chars, 0, size));
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		if (size == max) return;

		for (int dir = 0; dir < 8; dir++) {
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;

			if (nx < 0) nx = n - 1;
			if (nx >= n) nx = 0;
			if (ny < 0) ny = m - 1;
			if (ny >= m) ny = 0;

			isUsed[nx][ny] = true;
			chars[size] = world[nx][ny];
			makeWord(size + 1, nx, ny);
			isUsed[nx][ny] = false;
		}
	}
}
