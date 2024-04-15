package algorithm.solution.smileDK.baejoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        while(m-- > 0) {
            String s = br.readLine();
            if (set.contains(s)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
