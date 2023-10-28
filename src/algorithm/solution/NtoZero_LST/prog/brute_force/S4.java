package algorithm.solution.NtoZero_LST.prog.brute_force;

import algorithm.problem.programmers.bruteForce.P4;

public class S4 implements P4 {
    public int[] solution(int brown, int yellow) {
        // 카펫의 가로 세로 크기를 담을 배열 answer
        int[] answer = new int[2];
        // total은 brown과 yellow의 합
        int total = brown + yellow;

        // 너비는 total부터 시작해서 3이상 조건이어야 한다. (테두리 2칸 + 노란색 최소 1칸)
        // 너비가 높이보다 크거나 같으므로 너비를 최대값에서 -1씩 감산한다.
        for (int width = total; width >= 3; width--) {
            // total을 너비로 나누어 떨어지는 경우에만 width를 알 수 있다. (소수X)
            if (total % width == 0) {
                // 세로는 넓이/너비
                int height = total / width;
                // yellow의 넓이는 갈색 테두리를 제외해야하므로 너비-2 * 높이-2를 해야 한다.
                if (yellow == (width - 2) * (height - 2)) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}
