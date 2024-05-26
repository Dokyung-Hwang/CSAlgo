package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P9536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S9536_ implements P9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] mixedSounds = br.readLine().split(" ");
            HashMap<String, Boolean> map = new HashMap<>();

            while(true) {
                String[] animals = br.readLine().split(" ");

                if (animals[0].equals("what")) break;
                else {
                    map.put(animals[2], true);
                }
            }

            for (String str : mixedSounds) {
                if (!map.getOrDefault(str, false)) {
                    sb.append(str).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
