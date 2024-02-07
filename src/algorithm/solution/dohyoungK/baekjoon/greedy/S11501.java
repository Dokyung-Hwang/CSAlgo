package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S11501 implements P11501 {
// TODO: 주가를 입력받아 얻을 수 있는 최대 이익을 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] stocks = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            List<Pair> stockList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                stockList.add(new Pair(i, stocks[i]));
            }
            stockList.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return Integer.compare(o2.value, o1.value);
                }
            });

            Deque<Pair> sortedStocks = new ArrayDeque<>(stockList);
            long result = 0; // 주가의 최대 이익
            int index = 0; // 최대 주가의 인덱스
            while (index < N) {
                long sum = 0;
                Pair maxStock = findMaxStock(sortedStocks, index);
                int maxIndex = maxStock.index;
                int maxValue = maxStock.value;

                for (int i = index; i < maxIndex; i++) {
                    sum += stocks[i];
                }

                result += (long) maxValue * (maxIndex - index) - sum;
                index = maxIndex + 1;
            }

            System.out.println(result);
        }
    }

    private static Pair findMaxStock(Deque<Pair> sortedStocks, int index) {
        Pair maxStock = new Pair(0, 0);
        while (!sortedStocks.isEmpty()) {
            maxStock = sortedStocks.pollFirst();
            if (maxStock.index >= index) break;
        }

        return maxStock;
    }

    private static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
