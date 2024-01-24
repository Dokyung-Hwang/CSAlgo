package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P11724;

public class S11724 implements P11724 {
	// https://da9dac.tistory.com/297

	private static int n, m;
	private static int[][] nearArr;
	private static ArrayList<ArrayList<Integer>> nearList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nearArr = new int[n + 1][n + 1];
		nearList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			nearList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nearArr[x][y] = 1;
			nearArr[y][x] = 1;

			nearList.get(x).add(y);
			nearList.get(y).add(x);
		}

		long startTime, endTime, elapsedTime;

		// bfs_arr 메서드의 실행 시간 측정
		startTime = System.nanoTime();
		bfs_arr();
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("bfs_arr 실행 시간: " + elapsedTime + " 나노초");

		// bfs_list 메서드의 실행 시간 측정
		startTime = System.nanoTime();
		bfs_list();
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("bfs_list 실행 시간: " + elapsedTime + " 나노초");

		// dfs_arr 메서드의 실행 시간 측정
		startTime = System.nanoTime();
		dfs_arr();
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("dfs_arr 실행 시간: " + elapsedTime + " 나노초");

		// dfs_list 메서드의 실행 시간 측정
		startTime = System.nanoTime();
		dfs_list();
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("dfs_list 실행 시간: " + elapsedTime + " 나노초");
	}

	private static void dfs_arr() {
		int count = 0;

		boolean[] isVisited = new boolean[n + 1];

		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) continue;
			count++;
			stack.push(i);
			isVisited[i] = true;

			while (!stack.isEmpty()) {
				int cur = stack.pop();

				for (int j = 1; j <= n; j++) {
					if (isVisited[j] || nearArr[cur][j] != 1) continue;
					stack.push(j);
					isVisited[j] = true;
				}
			}
		}

		System.out.println(count);
	}

	private static void dfs_list() {
		int count = 0;
		boolean[] isVisited = new boolean[n + 1];

		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) continue;
			count++;
			stack.push(i);
			isVisited[i] = true;

			while (!stack.isEmpty()) {
				int cur = stack.pop();

				for (int near : nearList.get(cur)) {
					if (isVisited[near]) continue;
					stack.push(near);
					isVisited[near] = true;
				}
			}
		}

		System.out.println(count);
	}

	private static void bfs_arr() {
		int count = 0;
		boolean[] isVisited = new boolean[n + 1];

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) continue;
			count++;
			q.offer(i);
			isVisited[i] = true;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int j = 0; j <= n; j++) {
					if (nearArr[cur][j] != 1 || isVisited[j]) continue;
					q.offer(j);
					isVisited[j] = true;
				}
			}
		}

		System.out.println(count);
	}

	private static void bfs_list() {
		int count = 0;
		boolean[] isVisited = new boolean[n + 1];

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) continue;
			count++;
			q.offer(i);
			isVisited[i] = true;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int near : nearList.get(cur)) {
					if (isVisited[near]) continue;
					q.offer(near);
					isVisited[near] = true;
				}
			}
		}

		System.out.println(count);
	}
}
