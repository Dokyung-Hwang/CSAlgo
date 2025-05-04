package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S10890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        String inputStr = br.readLine();

        for (int i = 0; i < inputStr.length(); i++) {
            int index = inputStr.charAt(i) - 'a';
            if (alphabet[index] == -1) {
                alphabet[index] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int position : alphabet) {
            sb.append(position).append(" ");
        }

        System.out.println(sb.toString());
    }
}
