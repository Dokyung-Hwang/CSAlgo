package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1700 implements P1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] appliances = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        HashMap<Integer, Deque<Integer>> hm = new HashMap<>();
        for (int i = 0; i < K; i++) {
            Deque<Integer> deque = hm.getOrDefault(appliances[i], new ArrayDeque<>());
            deque.add(i);
            hm.put(appliances[i], deque);
        }

        Deque<Integer> multiTap = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < K; i++) {
            int appliance = appliances[i];
            hm.get(appliance).poll();

            if (multiTap.contains(appliance)) continue; // 멀티탭에 이미 장비가 꽃혀있을 때

            if (multiTap.size() < N) { // 멀티탭 빈자리가 존재할 때
                multiTap.add(appliance);
                continue;
            }

            count++;
            boolean chk = false;
            int lastIndex = 0;
            int lastAppliance = 0;
            for (int multiTapAppliance : multiTap) {
                Deque<Integer> order = hm.get(multiTapAppliance); // 다음 꽃
                if (order.isEmpty()) {
                    chk = true;
                    multiTap.remove(multiTapAppliance);
                    multiTap.add(appliance);
                    break;
                } else {
                    if (order.peek() > lastIndex) {
                        lastIndex = order.peek();
                        lastAppliance = multiTapAppliance;
                    }
                }
            }

            if (!chk) {
                multiTap.remove(lastAppliance);
                multiTap.add(appliance);
            }

            System.out.println(multiTap);
        }

        System.out.println(count);
    }
}
