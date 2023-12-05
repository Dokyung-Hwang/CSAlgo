package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.string.P1543;

public class S1543 implements P1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String target = br.readLine();

		int before = str.length();
		str = str.replace(target, "");
		int after = str.length();

		System.out.println((before - after) / target.length());
	}
}
