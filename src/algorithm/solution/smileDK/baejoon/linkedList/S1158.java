package algorithm.solution.smileDK.baejoon.linkedList;

import algorithm.problem.baekjoon.linkedList.P1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S1158 implements P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append('<');
        while(!list.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k-1) {
                    if (list.size() != 1)
                        sb.append(list.remove()).append(", ");
                    else
                        sb.append(list.remove());
                }
                else
                    list.add(list.remove());
            }
        }
        sb.append('>');

        System.out.println(sb);
    }
}
