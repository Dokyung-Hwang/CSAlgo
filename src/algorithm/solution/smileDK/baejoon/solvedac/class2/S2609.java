package algorithm.solution.smileDK.baejoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* Memo.
    유클리드 호제법(GCD)
    두 정수 a, b, r(a % b)
    GCD(a, b) = GCD(b, r)
    최대공약수(GCD)와 최소공배수(LCM)의 관계
    두 정수 a, b
    a x b = GCD(a, b) * LCM(a, b)
    => LCM(a, b) = a x b / GCD(a, b)
* */


public class S2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = getGCD(a, b);
        int lcm = (a * b) / gcd;

        sb.append(gcd).append("\n").append(lcm);
        System.out.println(18%24);
        System.out.println(sb);
    }

    public static int getGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
