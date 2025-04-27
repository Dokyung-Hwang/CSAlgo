package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 1; i <= 9; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp > max) {
                max = temp;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
