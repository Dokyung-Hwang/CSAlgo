package algorithm.solution.DokyungHwang.array;

import algorithm.problem.array.P10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Input: 길이 100 미만의 소문자 문자열 s
 * Output: 문자열에 포함되어 있는 각각의 알파 갯수
 *
 * S.
 * 아스키 코드 활용 - charAt(i) - 97('a')
 * */

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
