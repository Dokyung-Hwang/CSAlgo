package algorithm.solution.da9dac.linkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import algorithm.problem.linkedList.P1158;

public class S1158 implements P1158 {
	// https://da9dac.tistory.com/167

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write("<");

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		ListIterator<Integer> iterator = list.listIterator();

		int cur = 0;

		while (!list.isEmpty()) {
			if (list.size() == 1){
				bw.write(list.get(0) + "");
				list.remove(0);
			}
			else {
				for (int i = 0; i < k; i++) {
					if (iterator.hasNext()) {
						cur = iterator.next();
					} else {
						iterator = list.listIterator();
						cur = iterator.next();
					}

					if (i == k - 1 && list.size() > 1) {
						bw.write(cur + ", ");
						iterator.remove();
					}
				}
			}

		}

		bw.write(">");
		bw.flush();
		bw.close();
	}
}
