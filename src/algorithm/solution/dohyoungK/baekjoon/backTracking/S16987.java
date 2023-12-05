package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S16987 implements P16987 {
// Todo:
//  왼쪽 계란부터 차례로 들어서 깰 수 있는
//  계란의 최대 개수 출력

// Todo:
//  왼쪽 계란부터 차례로 계란을 깰 수 있는
//  모든 경우를 돌면서 결과적으로 각 경우마다 계란을 깬 개수 중 최댓값 출력
//  (모든 경우를 끝까지 돌지말고 중간에 끊을 수 있는 조건이 존재할 거 같은데 모르겠네)

    static Egg[] eggs;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        if (N == 1) {
            System.out.println(0);
            return;
        };

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            eggs[i] = new Egg(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        breakingEgg(0, 0);
        System.out.println(result);
    }

    // index : 왼쪽에 든 계란의 index
    private static void breakingEgg(int index, int breakEggNum) {
        boolean nextChk = false; // 다음에 깰 계란이 존재하는 지

        if (index == eggs.length) {
            result = Math.max(result, breakEggNum);
            return;
        }

        if (eggs[index].durability <= 0) {
            breakingEgg(index + 1, breakEggNum);
            return;
        }

        for (int i = 0; i < eggs.length; i++) {
            // 이미 든 계란과 깰 계란이 겹치지 않고, 깰 계란의 내구도가 1이상일 때
            if (i != index && eggs[i].durability > 0) {
                nextChk = true;
                eggs[index].durability -= eggs[i].weight;
                eggs[i].durability -= eggs[index].weight;

                if (eggs[index].durability <= 0 && eggs[i].durability <= 0) {
                    breakingEgg(index + 1, breakEggNum + 2);
                } else if (eggs[index].durability <= 0 || eggs[i].durability <= 0) {
                    breakingEgg(index + 1, breakEggNum + 1);
                } else {
                    breakingEgg(index + 1, breakEggNum);
                }

                eggs[index].durability += eggs[i].weight;
                eggs[i].durability += eggs[index].weight;
            }
        }

        if (!nextChk) breakingEgg(index + 1, breakEggNum);
    }

    private static class Egg {
        private int durability;
        private int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
