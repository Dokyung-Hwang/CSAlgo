package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1969 implements P1969 {
// TODO:
//  입력받은 DNA들과의 hammingDistance의 합이 가장 작은 (새로운) DNA 출력

// TODO:
//  DNA의 각 자리를 hm에 넣어서 각 글자의 count를 세고 정렬해
//  가장 카운트가 높은 글자로 DNA 만들기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] dnas = new String[N];
        StringBuilder resultDna = new StringBuilder();
        int result = 0;

        for (int i = 0; i < N; i++) {
            dnas[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            for (int j = 0; j < N; j++) {
                char key = dnas[j].charAt(i);
                int value = hm.getOrDefault(key, 0);
                hm.put(key, value + 1);
            }

            List<Character> keys = new ArrayList<>(hm.keySet());
            Collections.sort(keys, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if (hm.get(o1).compareTo(hm.get(o2)) == 0) {
                        return o1.compareTo(o2);
                    }
                    return hm.get(o2).compareTo(hm.get(o1));
                }
            });

            for (int j = 1; j < keys.size(); j++) {
                result += hm.get(keys.get(j));
            }
            resultDna.append(keys.get(0));
        }

        System.out.println(resultDna);
        System.out.println(result);
    }
}
