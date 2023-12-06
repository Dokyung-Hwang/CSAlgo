package algorithm.solution.NtoZero_LST.boj.string;

import java.io.*;
import java.util.*;

public class S2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String crypto = br.readLine();
        int N = crypto.length();

        int R=0, C = 0;

        for(int i = (int) Math.sqrt(N); i >=1; i--) {
            if(N%i==0) {
                R = i; // 나누어 떨어지면 그 값이 R의 최대
                C = N/R;
                break;
            }
        }

//        char[][] chars = new char[R][C];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                sb.append(crypto.charAt(j*R+i));
            }
        }

        System.out.println(sb.toString());
    }
}
