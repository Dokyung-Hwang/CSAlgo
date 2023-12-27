package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.greedy.P2457;

public class S2457 implements P2457 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] flowers = new int[n][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			flowers[i][0] = Integer.parseInt(st.nextToken());
			flowers[i][1] = Integer.parseInt(st.nextToken());
			flowers[i][2] = Integer.parseInt(st.nextToken());
			flowers[i][3] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(flowers, (a, b) -> a[2] != b[2] ? a[2] - b[2] : a[3] - b[3]);

		System.out.println(Arrays.deepToString(flowers));

		int msm = 0;	// 이전까지의 꽃이 피는 달
		int msd = 0;	// 이전까지의 꽃이 피는 날
		int mem = 0;	// 이전까지의 꽃이 지는 달
		int med = 0;	// 이전까지의 꽃이 지는 날
		int min = 0;

		for (int i = 0; i < n; i++) {
			int sm = flowers[i][0]; // 꽃이 피는 달
			int sd = flowers[i][1]; // 꽃이 피는 날
			int em = flowers[i][2]; // 꽃이 지는 달
			int ed = flowers[i][3]; // 꽃이 지는 날

			// 3월 이전 혹은 3월 1일 이후부터 피기 시작해서 3월 1일 이후에도 꽃이 피는 경우
			if ((sm < 3 && (em > 3 || em == 3 && ed > 1)) || (sm == 3 && sd == 1)) {
				min = 1;
				msm = sm;
				msd = sd;
				mem = em;
				med = ed;
				continue;
			}

			// 이전 꽃보다 피는 날이 같거나 빠르고 지는 기간이 더 길다면
			// 카운트를 늘리지 않음 = 이전 꽃 대신 교체하는 것이기 때문에
			if ((msm > sm || (msm == sm && msd >= sd)) && (mem < em || (mem == em && med < ed))) {

			}
		}

		System.out.println(min);
	}
}
