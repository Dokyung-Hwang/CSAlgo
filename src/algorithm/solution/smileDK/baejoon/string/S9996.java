package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9996 implements P9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] splitPattern = br.readLine().split("\\*");     // \\* == [*]
        int len = splitPattern[0].length() + splitPattern[1].length();

        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();

            if (fileName.length() >= len && fileName.startsWith(splitPattern[0]) && fileName.endsWith(splitPattern[1])) {
                sb.append("DA").append("\n");
            }
            else {
                sb.append("NE").append("\n");
            }
        }

        System.out.println(sb);
    }
}
