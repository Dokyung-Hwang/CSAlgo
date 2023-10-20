package algorithm.solution.NtoZero_LST.boj.array;


import algorithm.problem.baejoon.array.P2577;

import java.io.*;

public class S2577 implements P2577 {
    public static void main(String[] args) throws IOException {
        /*
        시간 제한 1초, 메모리 제한 128MB
     */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int sum = A*B*C;
        // sum의 자리 수를 분할하기 위한 String
        String sumString = String.valueOf(sum);

        // 0~9까지 10개의 숫자의 개수를 차례대로 인덱싱해 받을 정렬
        int[] countArr = new int[10];

        for(int i=0; i<sumString.length(); i++) {
            int idx = sumString.charAt(i)-'0'; // char -> int
            countArr[idx]++;
        }

        for(int i=0; i<countArr.length; i++) {
            bw.write(countArr[i]+"\n");
        }
        bw.close();
    }
}
