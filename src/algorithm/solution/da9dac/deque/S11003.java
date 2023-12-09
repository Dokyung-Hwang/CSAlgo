package algorithm.solution.da9dac.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());


		/*
			12 3
			1 5 2 3 6 2 3 7 3 5 2 6

			1	1
			1 5		1
			1 5 2		1
			1 5 2 3		2
			1 5 2 3 6	3
			1 5 2 3 6 2		4
			1 5 2 3 6 2 3	5
			1 5 2 3 6 2 3 7		6
			1 5 2 3 6 2 3 7 3	7
			1 5 2 3 6 2 3 7 3 5		8
			1 5 2 3 6 2 3 7 3 5 2	9
			1 5 2 3 6 2 3 7 3 5 2 6		10
		 */
	}
}
