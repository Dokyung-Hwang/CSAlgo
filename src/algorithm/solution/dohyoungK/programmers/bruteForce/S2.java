package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P2;

import java.util.ArrayList;
import java.util.List;

public class S2 implements P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5,1,2,3,4,5,1,2,3,4,5}));
    }

// TODO:
//  문제 답을 입력받아
//  1,2,3 수포자 중 가장 많이 정답을 맞춘 사람 출력

// TODO:
//  수포자1 = [1,2,3,4,5...],
//  수포자2 = [2,1,2,3,2,4,2,5...],
//  수포자3 = [3,3,1,1,2,2,4,4,5,5...],
//  수포자들의 패턴은 이렇게 반복되고
//  그 패턴 중 맞은 문제 수 기록

    public static int[] solution(int[] answers) {
        List<List<Integer>> patterns = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1,2,3,4,5)),
                new ArrayList<>(List.of(2,1,2,3,2,4,2,5)),
                new ArrayList<>(List.of(3,3,1,1,2,2,4,4,5,5))));

        int[] corrects = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (patterns.get(i).get(j % patterns.get(i).size()).equals(answers[j])) {
                    corrects[i]++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int correctMax = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));
        if (correctMax == corrects[0]) result.add(1);
        if (correctMax == corrects[1]) result.add(2);
        if (correctMax == corrects[2]) result.add(3);

        return result.stream().mapToInt(e -> e).toArray();
    }
}
