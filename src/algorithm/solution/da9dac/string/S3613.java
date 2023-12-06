package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.string.P3613;

public class S3613 implements P3613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String before = br.readLine();

		if (before.charAt(0) == '_' || before.charAt(before.length() - 1) == '_' || before.contains("__")) {
			System.out.println("Error!");
			return;
		}

		boolean isContain = before.contains("_");

		if (isContain && before.equals(before.toLowerCase())) {
			String[] arr = before.split("_");

			for (int i = 1; i < arr.length; i++) {
				arr[i] = arr[i].replaceFirst(String.valueOf(arr[i].charAt(0)), String.valueOf(arr[i].charAt(0)).toUpperCase());
			}

			String result = String.join("", arr);
			System.out.println(result);

		} else if (before.equals(before.toLowerCase())) {
			System.out.println(before);
		} else if (Character.isLowerCase(before.charAt(0)) && !isContain){
			StringBuilder sb = new StringBuilder();
			char[] arr = before.toCharArray();

			sb.append(Character.toLowerCase(arr[0]));

			for (int i = 1; i < arr.length; i++) {
				if (Character.isUpperCase(arr[i])) {
					sb.append("_").append(Character.toLowerCase(arr[i]));
				} else {
					sb.append(arr[i]);
				}
			}

			System.out.println(sb);
		} else {
			System.out.println("Error!");
		}
	}
}
