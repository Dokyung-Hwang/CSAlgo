package algorithm.solution.smileDK.baejoon.deque;

import algorithm.problem.baekjoon.deque.P10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class S10866 implements P10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
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


    /*Todo
        push_front X: 정수 X를 덱의 앞에 넣는다.
        push_back X: 정수 X를 덱의 뒤에 넣는다.
        pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 덱에 들어있는 정수의 개수를 출력한다.
        empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
        front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

    private static Deque<Integer> deque = new LinkedList<>();

    // 정수 X를 덱의 앞에 넣는다.
    public static void push_front(int x) {
        deque.addFirst(x);
    }

    // 정수 x를 덱의 뒤에 넣는다.
    public static void push_back(int x) {
        deque.addLast(x);
    }

    // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력
    public static int pop_front() {
        if (deque.isEmpty()) return -1;
        else return deque.pollFirst();
    }

    //덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력
    public static int pop_back() {
        if (deque.isEmpty()) return -1;
        else return deque.pollLast();
    }

    // 덱에 들어있는 정수의 개수를 출력
    public static int size() {
        return deque.size();
    }

    // 덱이 비어있으면 1을, 아니면 0을 출력
    public static int empty() {
        if (deque.isEmpty()) return 1;
        else return 0;
    }

    // 덱의 가장 앞에 있는 정수를 출력. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력
    public static int front() {
        if (deque.isEmpty()) return -1;
        else return deque.getFirst();
    }

    // 덱의 가장 뒤에 있는 정수를 출력. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력
    public static int back() {
        if (deque.isEmpty()) return -1;
        else return deque.getLast();
    }
}
