package algorithm.solution.kimhaming.baekjoon.queue;

import algorithm.problem.baekjoon.queue.P10845;

import java.io.*;
import java.util.*;

public class S10845 implements P10845 {
    // https://velog.io/@haminggu/백준Java-4949번-균형잡힌-세상
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) push(Integer.parseInt(st.nextToken()));
            if (str.equals("pop")) pop();
            if (str.equals("size")) size();
            if (str.equals("empty")) empty();
            if (str.equals("front")) front();
            if (str.equals("back")) back();
        }
        System.out.print(sb);
    }

    static void push(int x) {
        q.add(x);
    }

    static void pop() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(q.remove() + "\n");
        }
    }

    static void size() {
        sb.append(q.size() + "\n");
    }

    static void empty() {
        if (q.isEmpty()) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    static void front() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(q.peek() + "\n");
        }
    }

    static void back() {
        if (q.isEmpty()) {
            sb.append("-1\n");
            return;
        }
        int num = q.size();
        for (int i = 0; i < num - 1; i++) {
            q.add(q.remove());
        }
        sb.append(q.peek() + "\n");
//        q.add(q.remove());
    }
}
