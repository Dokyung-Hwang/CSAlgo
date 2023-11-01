package algorithm.solution.smileDK.baejoon.queue;

import algorithm.problem.baekjoon.queue.P10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


/*Todo:
   push X: 정수 X를 큐에 넣는 연산이다.
   pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
   size: 큐에 들어있는 정수의 개수를 출력한다.
   empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
   front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
   back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/
public class S10845 implements P10845 {
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
