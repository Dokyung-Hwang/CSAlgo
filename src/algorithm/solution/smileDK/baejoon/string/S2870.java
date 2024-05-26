package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P2870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class S2870 implements P2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayList<BigInteger> numList = new ArrayList<>();

        while (n-- > 0) {
            String[] lines = br.readLine().split("[a-z]");

            for (String s : lines) {
                if (!s.isEmpty()) numList.add(new BigInteger(s));
            }
        }

        numList.sort(BigInteger::compareTo);

        for (BigInteger bi : numList) {
            sb.append(bi).append("\n");
        }

        System.out.println(sb);
    }
}
