package algorithm.solution.DokyungHwang.array;


import algorithm.problem.array.P2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2577_ref implements P2577 {
    // 몫, 나머지 연산을 이용한 방법
    // Reference: https://st-lab.tistory.com/45
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while(val != 0) {
            arr[val%10]++;
            val/=10;
        }
        // 1 7 0 3 7 3 0 0

        // 0 1 2 3 4 5 6 7 8 9
        // 3 1 0 2 0 0 0 2 0 0

        // Output
        for(int result : arr) {
            System.out.println(result);
        }
    }
}

// Review: 굳이 문자열 변환 과정이 없어서 charAt() 쓰지 않고 연산 만으로 문제를 해결
