package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P9536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9536 implements P9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] mixedSounds = br.readLine().split(" ");

            while(true) {
                String[] animals = br.readLine().split(" ");

                if (animals[0].equals("what")) break;
                else {
                    for (int i = 0; i < mixedSounds.length; i++) {
                        if (animals[2].equals(mixedSounds[i])) {
                            mixedSounds[i] = "";
                        }
                    }
                }
            }

            for (String str : mixedSounds) {
                if (!str.isEmpty()) {
                    sb.append(str).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
