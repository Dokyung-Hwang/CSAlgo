package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int verificationNumber = 0;

        while(st.hasMoreTokens()){
            verificationNumber += (int)(Math.pow(Integer.parseInt(st.nextToken()), 2));
        }

        System.out.println(verificationNumber % 10);
    }
}
