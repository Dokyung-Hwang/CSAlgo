package algorithm.solution.NtoZero_LST.boj.string;

import java.io.*;
import java.util.*;

public class S1513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String src = br.readLine();
        String target = br.readLine();

        int startIdx = 0;
        int count = 0;
        while(startIdx+target.length()<= src.length()) {
            String tmp = src.substring(startIdx, startIdx + target.length());
            if(target.equals(tmp)) {
                count++;
                startIdx += target.length();
            } else
                startIdx++;
        }

        System.out.println(count);
    }
}
