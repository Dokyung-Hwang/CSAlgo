package algorithm.solution.dohyoungK.array;

import algorithm.problem.array.P3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class S3273 implements P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());
        int result = 0;

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) hm.put(Integer.valueOf(arr[i]), i);

        for (int i = 0; i < n - 1; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num >= sum) continue;

            int index = hm.getOrDefault(sum - num, -1);
            if (index != -1 && index > i) result += 1;
        }

        System.out.println(result);
    }
}
