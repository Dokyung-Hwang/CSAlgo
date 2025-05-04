package algorithm.solution.smileDK.baejoon.solvedac.class1;

import algorithm.problem.baekjoon.array.P2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2577 implements P2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numCount = new int[10];
        String str = String.valueOf(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()));

        for (int i = 0; i < str.length(); i++) {
            numCount[str.charAt(i) - 48]++;
        }

        for (int num : numCount) {
            System.out.println(num);
        }
    }
}
