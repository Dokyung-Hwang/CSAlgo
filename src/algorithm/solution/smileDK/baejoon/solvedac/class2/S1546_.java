package algorithm.solution.smileDK.baejoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1546_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double score;
        double max = Double.MIN_VALUE;
        double sum = 0.0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score = Double.parseDouble(st.nextToken());
            if (score > max) {
                max = score;
            }
            sum += score;
        }

        double avg = (sum / max * 100)/n;
        System.out.println(avg);

    }
}
