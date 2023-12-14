package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P15312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class S15312 implements P15312 {
    static int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        Integer[] strokeNums = new Integer[a.length() + b.length()];

        for (int i = 0; i < a.length(); i++) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            strokeNums[i * 2] = alphabet[ac - 65];
            strokeNums[(i * 2) + 1] = alphabet[bc - 65];
        }

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(strokeNums));
        while (list.size() > 2) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list = temp;
        }

        list.forEach(System.out::print);
    }
}
