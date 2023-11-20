package algorithm.solution.smileDK.baejoon.sort;

import algorithm.problem.baekjoon.sort.P11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11728 implements P11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + m];

        st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int j = i;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[j] = Integer.parseInt(st.nextToken());
            j++;
        }

        Arrays.sort(arr);


        for(int r : arr) {
            sb.append(r).append(" ");

        }
        System.out.println(sb);
    }
}
