package algorithm.solution.smileDK.baejoon.sort;

import algorithm.problem.baekjoon.sort.P11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11728_twoPoint implements P11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0;

        while(p1 < n && p2 < m) {
            if(a[p1] <= b[p2]) {
                sb.append(a[p1++]).append(" ");
            }
            else {
                sb.append(b[p2++]).append(" ");
            }
        }

        //두개의 배열 길이가 같지 않은 경우 값을 다 담지 못하는 경우가 발생
        //그래서 한 배열의 탐색이 완료한 후에는 다른 배열의 남아있는 값도 넣어주어야 한다.
        if(p1==n) {
            for (int i = p2; i < m; i++) {
                sb.append(b[i]).append(" ");
            }
        }
        if(p2==m) {
            for (int i = p1; i < n; i++) {
                sb.append(a[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
