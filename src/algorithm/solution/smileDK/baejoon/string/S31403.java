package algorithm.solution.smileDK.baejoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());


//        String ab = a + String.valueOf(b);
        String ab = "";
        ab += a;
        ab += b;

        int abc = Integer.parseInt(ab) - c;

        System.out.println(a + b - c);
        System.out.println(abc);
    }
}
