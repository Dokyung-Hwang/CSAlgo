package algorithm.solution.smileDK.programmers.string;

import java.util.Arrays;

public class QuizOX {
    public static void main(String[] args) {
        String[] quiz1 = {"3 - 4 = -3", "5 + 6 = 11"};
        String[] quiz2 = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};

        System.out.println(Arrays.toString(solution(quiz1)));
        System.out.println(Arrays.toString(solution(quiz2)));
    }


    public static String[] solution(String[] quiz) {
        for (int i = 0; i < quiz.length; i++) {
            String[] formula = quiz[i].split(" ");
            int operand1 = Integer.parseInt(formula[0]);
            int operand2 = Integer.parseInt(formula[2]);
            int result = Integer.parseInt(formula[4]);
            int operationResult = operand1 + operand2 * (formula[1].equals("+") ? 1 : -1);
            quiz[i] = (operationResult == result)? "O": "X";
        }

        return quiz;
    }
}
