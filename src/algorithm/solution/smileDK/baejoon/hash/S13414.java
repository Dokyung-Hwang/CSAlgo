package algorithm.solution.smileDK.baejoon.hash;

import algorithm.problem.baekjoon.hash.P13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S13414 implements P13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int capacity = Integer.parseInt(st.nextToken());
        int waiting = Integer.parseInt(st.nextToken());

        int count = 0;

        Set<String> linkedHashSet = new LinkedHashSet<>();

        for (int i = 0; i < waiting; i++) {
            String studentId = br.readLine();
            if (linkedHashSet.contains(studentId)) linkedHashSet.remove(studentId);
            linkedHashSet.add(studentId);
        }

        for (String element : linkedHashSet) {
            System.out.println(element);
            count++;
            if (count >= capacity) break;
        }
    }
}
