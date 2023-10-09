package algorithm.solution.dohyoungK.stack;

import algorithm.problem.stack.P1874;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S1874 implements P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Character> resultOperators = new ArrayDeque<>();
        Deque<Integer> resultNums = new ArrayDeque<>();
        Deque<Integer> inputNums = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            inputNums.add(Integer.parseInt(br.readLine()));
            nums.add(i);
        }

        while (!inputNums.isEmpty()) {
            if (!inputNums.getFirst().equals(resultNums.peekLast())) {
                if (nums.isEmpty() || (!resultNums.isEmpty() && inputNums.getFirst() < resultNums.peekLast())) {
                    System.out.println("NO");
                    return;
                }
                resultOperators.add('+');
                resultNums.add(nums.poll());
            } else {
                resultOperators.add('-');
                resultNums.pollLast();
                inputNums.pollFirst();
            }
        }

//        try {
//            while (!inputNums.isEmpty()) {
//                if (!inputNums.getFirst().equals(resultNums.peekLast())) {
//                    resultOperators.add('+');
//                    resultNums.add(nums.poll());
//                } else {
//                    resultOperators.add('-');
//                    resultNums.pollLast();
//                    inputNums.pollFirst();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("NO");
//            return;
//        }

        for (char op : resultOperators) {
            System.out.println(op);
        }
    }
}
