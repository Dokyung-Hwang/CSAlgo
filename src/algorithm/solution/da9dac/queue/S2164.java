package algorithm.solution.da9dac.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.problem.queue.P2164;

public class S2164 implements P2164 {
	// https://da9dac.tistory.com/175

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}


		while (queue.size() != 1) {
			queue.poll();
			queue.offer(queue.poll());
		}

		bw.write(queue.poll() + "");
		bw.flush();
		bw.close();
	}
}
