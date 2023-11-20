package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.sort.P10814;

public class S10814 implements P10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Member[] members = new Member[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		Arrays.sort(members);

		for (Member member : members) {
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}

		System.out.println(sb);
	}

	private static class Member implements Comparable<Member> {
		int age;
		String name;

		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			return this.age - o.age;
		}
	}
}
