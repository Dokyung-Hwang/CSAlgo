package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.backTracking.P1182;

import java.io.*;
import java.util.*;

public class S1181 implements P1182 {
// TODO:
//  N개의 알파벳을 입력받아 조건에 맞춰 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, int[]> hm = new HashMap<>(); // value의 배열은 [빈도, 인덱스]

        for (int i = 0; i < nums.length; i++) {
            int[] value = hm.getOrDefault(nums[i], new int[]{0, i});
            value[0] += 1;
            hm.put(nums[i], value);
        }

        List<Integer> keySet = new ArrayList<>(hm.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int[] arr1 = hm.get(o1);
                int[] arr2 = hm.get(o2);

                if (arr1[0] > arr2[0]) return -1;
                else if (arr1[0] < arr2[0]) return 1;
                else {
                    if (arr1[1] < arr2[1]) return -1;
                    else return 1;
                }
            }
        });

        for (int key : keySet) {
            for (int i = 0; i < hm.get(key)[0]; i++) {
                bw.write(key + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
