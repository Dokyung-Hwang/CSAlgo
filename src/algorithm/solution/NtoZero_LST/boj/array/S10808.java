package algorithm.solution.NtoZero_LST.boj.array;


import algorithm.problem.baejoon.array.P10808;

import java.io.*;

public class S10808 implements P10808 {

    public static void main(String[] args) throws IOException {
        /*
            시간 제한 1초, 메모리 제한 256MB
            N = 10^2 이므로 O(N^4) 이하의 방법을 허용 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String S = br.readLine();

        // a~z를 담는 배열 생성
        int[] alphabetArr = new int[26];

        // a~z를 0~26 인덱스로 환산하여 받아준다. (ASCII 코드)
        for(int i=0; i<S.length(); i++) {
            int idx = S.charAt(i) - 97;
            alphabetArr[idx]++;
        }

        for(int i=0; i<alphabetArr.length; i++) {
            bw.write(alphabetArr[i] + " ");
        }
        bw.close();
    }
}
