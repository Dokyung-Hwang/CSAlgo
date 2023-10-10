package algorithm.solution.kimhaming.array;

import algorithm.problem.array.P2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class S2577 implements P2577 {
    // https://velog.io/@haminggu/백준Java-2577번-숫자의-개수

    /**
     * Todo: 세 자연수의 곱의 결과에 포함된 0부터 9까지 각 숫자의 빈도를 출력
     * 1. 자연수 A,B,C 를 입력받기 위해 Scanner 사용
     * 2. counts 배열에 0부터 9까지의 숫자가 몇 번 나오는지 저장
     * 3. number에 세 수의 곱 저장
     * 4. number의 가장 오른쪽에 있는 숫자(자릿수)를 제거하고 다음 자릿수로 이동하기 위해 number를 10으로 나누며 반복
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] counts = new int[10];
        int number = A * B * C;
        while (number > 0) {    // A,B,C는 자연수라는 조건을 문제에서 제시하고 있기 때문에
            counts[number % 10]++;
            number /= 10;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }
    }
}
