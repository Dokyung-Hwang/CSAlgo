package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int score = 0;
            int current = 1;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == 'O') {
                    score += current++;
                }
                else {
                    current = 1;
                }
            }
            sb.append(score).append("\n");
        }

        System.out.println(sb.toString());
    }
}
