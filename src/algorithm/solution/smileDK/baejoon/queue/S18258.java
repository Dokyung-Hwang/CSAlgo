package algorithm.solution.smileDK.baejoon.queue;

import algorithm.problem.baekjoon.queue.P18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S18258 implements P18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    private static LinkedList<Integer> queue = new LinkedList<>();

    public static void push(int x) {
        queue.add(x);
    }

    public static int pop() {
        if (queue.isEmpty())
            return -1;
        else {
            int temp = queue.get(0);
            queue.remove(queue.get(0));
            return temp;
        }
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        if (queue.isEmpty()) return 1;
        else return 0;
    }

    public static int front() {
        if (queue.isEmpty()) return -1;
        else return queue.get(0);
    }

    public static int back() {
        if (queue.isEmpty()) return -1;
        else return queue.get(queue.size() - 1);
    }

}
