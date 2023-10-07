package algorithm.solution.dohyoungK.linkedList;

import algorithm.problem.linkedList.P1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1158 implements P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        int cnt = 0;
        int index = 0;
        List<Integer> result = new ArrayList<>();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        while (!list.isEmpty()) {
            cnt++;

            if (cnt == K){
                cnt = 0;
                result.add(list.get(index));
                list.remove(index);
            } else index++;

            if (index >= list.size()) index = 0;
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(result.get(i));
            if (i != N - 1) System.out.print(", ");
        }
        System.out.println(">");
    }
}
