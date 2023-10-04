package algorithm.solution.da9dac.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.array.P3273;

public class S3273 implements P3273 {
	// https://da9dac.tistory.com/164

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split(" ");
		int x = Integer.parseInt(br.readLine());

		int[] arr = new int[2000001];
		int count = 0;

		for (String number : numbers) {
			int num = Integer.parseInt(number);

			if (x - num >= 1 && arr[x - num] == 1) {
				count++;
			}

			arr[num] = 1;
		}

		System.out.println(count);
	}
}
