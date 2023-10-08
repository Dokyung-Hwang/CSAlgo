package algorithm.solution.DokyungHwang.array;

import algorithm.problem.array.P10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S10808 implements P10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphaArr = new int[26];
		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			alphaArr[c - 'a']++;
		}

		// Output
        for (int j : alphaArr) {
            System.out.print(j + " ");
        }
	}
}
