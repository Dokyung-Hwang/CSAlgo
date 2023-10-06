package algorithm.solution.dohyoungK.linkedList;

import algorithm.problem.linkedList.P1406;

import java.io.*;
import java.util.*;

// linkedlist 시간초과?
// 삽입, 삭제의 시간복잡도가 O(1)이긴 하지만
// 리스트의 중간에 삽입, 삭제를 할 때
// 결국 그 인덱스 위치를 찾아갈 때
// O(N)이 걸린다고 함 (그럼 왜 쓰는건데?)
public class S1406 implements P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String text = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> right = new ArrayDeque<>();
        Deque<Character> left = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            left.add(text.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.add(right.poll());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                case 'P':
                    left.add(command.charAt(2));
                    break;
            }
        }

        for (char c : left) bw.write(c);
        for (char c : right) bw.write(c);
        bw.flush();
        bw.close();
    }
}
