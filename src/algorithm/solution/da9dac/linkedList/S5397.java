package algorithm.solution.da9dac.linkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import algorithm.problem.linkedList.P5397;

public class S5397 implements P5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			char[] testCase = br.readLine().toCharArray();

			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> iterator = list.listIterator();

			for (char c : testCase) {
				switch (c) {
					case '-': {
						if (iterator.hasPrevious()) {
							iterator.previous();
							iterator.remove();
						}
						break;
					}
					case '<': {
						if (iterator.hasPrevious()) {
							iterator.previous();
						}
						break;
					}
					case '>': {
						if (iterator.hasNext()) {
							iterator.next();
						}
						break;
					}
					default: {
						iterator.add(c);
						break;
					}
				}
			}

			for (char ch : list) {
				bw.write(ch);
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
