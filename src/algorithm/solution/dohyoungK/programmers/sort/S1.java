package algorithm.solution.dohyoungK.programmers.sort;

import algorithm.problem.programmers.sort.P1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class S1 implements P1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        for (int[] command : commands) {
            List<Integer> subList = new ArrayList<>(list.subList(command[0] - 1, command[1]));
            Collections.sort(subList);
            result.add(subList.get(command[2]-1));
        }

        return result.stream().mapToInt(e -> e).toArray();
    }
}
