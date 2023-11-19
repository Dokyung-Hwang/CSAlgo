package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.sort.P5648;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class S5648 implements P5648 {
// TODO:
//  N개의 수를 입력받아 그 수를 뒤집은 수들을 정렬

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        long[] nums = new long[N];
        int index = 0;

        while (index < N) {
            StringBuilder sb = new StringBuilder(sc.next());
            nums[index++] = Long.parseLong(sb.reverse().toString());
        }

        Arrays.sort(nums);

        Arrays.stream(nums).forEach(num -> {
            try {
                bw.write(num + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
    }
}
