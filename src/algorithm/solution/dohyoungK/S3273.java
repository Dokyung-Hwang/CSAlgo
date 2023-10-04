package algorithm.solution.dohyoungK;

import algorithm.problem.array.P3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class S3273 implements P3273 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            int targetNum = sum - Integer.parseInt(arr[i]);
            System.out.println(sum);
            System.out.println(targetNum);
            System.out.println();
            if (Integer.parseInt(arr[i]) != targetNum && Arrays.asList(arr).contains(targetNum))
                result += 1;
        }

        System.out.println(result);
    }
}
