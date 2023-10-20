package algorithm.solution.NtoZero_LST.prog.sort;

import algorithm.problem.programmers.sort.P1;

import java.util.Arrays;

public class S1 implements P1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int kOrder = commands[i][2];

            int[] temp = new int[array.length];
            temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp); // NlogN
            answer[i] = temp[kOrder-1];
        }
        return answer;
    }
}
