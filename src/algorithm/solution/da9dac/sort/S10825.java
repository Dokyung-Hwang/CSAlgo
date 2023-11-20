package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.sort.P10825;

public class S10825 implements P10825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Record[] records = new Record[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			records[i] = new Record(
				st.nextToken(),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
		}

		Arrays.sort(records);

		for (Record record : records) {
			sb.append(record.name).append("\n");
		}

		System.out.println(sb);
	}

	private static class Record implements Comparable<Record> {
		String name;
		int korean;
		int english;
		int math;

		public Record(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Record o) {
			int korDiff = this.korean - o.korean;
			int engDiff = this.english - o.english;
			int mathDiff = this.math - o.math;

			if (korDiff != 0) {
				return -korDiff;
			} else if (engDiff != 0) {
				return engDiff;
			} else if (mathDiff != 0) {
				return -mathDiff;
			} else {
				return name.compareTo(o.name);
			}
		}
	}
}
