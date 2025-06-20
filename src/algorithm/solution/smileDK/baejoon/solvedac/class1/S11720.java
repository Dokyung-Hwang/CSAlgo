package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String sNum = br.readLine();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += sNum.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
