package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithm.problem.baekjoon.string.P2870;

public class S2870 implements P2870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<BigInteger> list = new ArrayList<>();

		while (n-- > 0) {
			String[] strs = br.readLine().split("[a-z]");
			for (String str : strs) {
				if (!str.isEmpty()) list.add(new BigInteger(str));
			}
		}

		Collections.sort(list);

		for (BigInteger i : list) {
			sb.append(i).append("\n");
		}

		System.out.println(sb);
	}
}
