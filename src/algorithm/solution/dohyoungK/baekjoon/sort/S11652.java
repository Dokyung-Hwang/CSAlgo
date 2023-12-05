package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.sort.P11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S11652 implements P11652 {
// TODO:
//  N개의 숫자카드를 입력받아 자신이 가장 많이 가지고있는 숫자 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> cards = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long key = Long.parseLong(br.readLine());
            cards.put(key, cards.getOrDefault(key, 0) + 1);
        }

        List<Long> keySet = new ArrayList<>(cards.keySet());
        keySet.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (cards.get(o1).compareTo(cards.get(o2)) == 0) {
                    return o1.compareTo(o2);
                }

                return cards.get(o2).compareTo(cards.get(o1));
            }
        });

        System.out.println(keySet.get(0));
    }
}
