package algorithm.solution.smileDK.baejoon.stack;

import algorithm.problem.baekjoon.stack.P10828;

import java.util.Scanner;
import java.util.Stack;

/* TODO
*   Q. 스택 구현 후 입력으로 주어진 명령을 처리하는 프로그램
    push X: 정수 X를 스택에 넣는 연산이다.
    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 스택에 들어있는 정수의 개수를 출력한다.
    empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

public class S10828 implements P10828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

         stack = new int[n];

         for (int i = 0; i < n; i++) {
             String str = sc.next();

             switch (str) {
                 case "push":
                     push(sc.nextInt());
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
                 case "top":
                     sb.append(top()).append('\n');
                     break;
             }

         }
        System.out.println(sb);

    }

    public static int[] stack;
    public static int size = 0;

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if (size == 0) return -1;
        else {
            int result = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return result;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) return 1;
        else return 0;
    }

    public static int top() {
        if (size == 0) return -1;
        else return stack[size - 1];
    }
}
