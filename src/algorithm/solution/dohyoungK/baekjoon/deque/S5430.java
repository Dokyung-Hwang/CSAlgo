package algorithm.solution.dohyoungK.baekjoon.deque;

import algorithm.problem.baekjoon.deque.P5430;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class S5430 implements P5430 {
// Todo:
//  함수 R, D 에 따라 배열에
//  명령을 수행하고 최종 결과 출력
//  (R: 배열 수 뒤집기)
//  (D: 첫번째 수 빼기)

// Todo:
//  문제 풀이보다 출력 조건 맞추기가 더 빡센문제...

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] array = input.substring(1, input.length() - 1).split(",");

            if (n == 0) array = new String[0];

            Deque<String> deque = Arrays.stream(array).collect(Collectors.toCollection(ArrayDeque::new));

            boolean front = true;
            boolean error = false;

            for (String s : func.split("")) {
                if (s.equals("R")) {
                    front = !front;
                } else {
                    if (front) {
                        if (!deque.isEmpty()) {
                            deque.pollFirst();
                        } else {
                            error = true;
                            break;
                        }
                    } else {
                        if (!deque.isEmpty()) {
                            deque.pollLast();
                        } else {
                            error = true;
                            break;
                        }
                    }
                }
            }

            if (error) {
                bw.write("error" + "\n");
            } else {
                if (front) {
                    bw.write("[");
                    while (!deque.isEmpty()) {
                        bw.write(deque.pollFirst());
                        if (!deque.isEmpty()) {
                            bw.write(",");
                        }
                    }
                    bw.write("]\n");
                } else {
                    bw.write("[");
                    while (!deque.isEmpty()) {
                        bw.write(deque.pollLast());
                        if (!deque.isEmpty()) {
                            bw.write(",");
                        }
                    }
                    bw.write("]\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
