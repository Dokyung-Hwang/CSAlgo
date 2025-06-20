package algorithm.solution.smileDK.baejoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
1. 입력받은 정수 중 가장 큰 값을 찾는다
2. 가장 큰 수 판별
3. 각각의 수를 주어진 식에 대입
4. 평균 값 계산
5. 출력

* */
public class S1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] score = new double[N];
        double maxScore = Double.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
            if (score[i] > maxScore) {
                maxScore = score[i];
            }
        }

        double sum = 0.0;

        for (int i = 0; i < N; i++) {
            sum += (score[i]/maxScore)*100.0;
        }

        double avg = sum/N;
        System.out.println(avg);

    }
}
