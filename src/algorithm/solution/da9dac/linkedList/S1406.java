package algorithm.solution.da9dac.linkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import algorithm.problem.linkedList.P1406;

public class S1406 implements P1406 {
	// https://da9dac.tistory.com/165

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String before = br.readLine();
		int m = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> iterator = list.listIterator();

		for (char c : before.toCharArray()) {
			iterator.add(c);
		}

		for (int i = 0; i < m; i++) {
			String command = br.readLine();

			switch (command.charAt(0)) {
				case 'P': {
					iterator.add(command.charAt(2));
					break;
				}
				case 'L': {
					if (iterator.hasPrevious()) {
						iterator.previous();
					}
					break;
				}
				case 'D': {
					if (iterator.hasNext()) {
						iterator.next();
					}
					break;
				}
				case 'B': {
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
					break;
				}
			}
		}

		for (Character c : list) {
			bw.write(c);
		}

		bw.flush();
		bw.close();
	}
}
