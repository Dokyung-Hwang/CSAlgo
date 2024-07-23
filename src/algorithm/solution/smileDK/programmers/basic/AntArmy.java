package algorithm.solution.smileDK.programmers.basic;


// https://school.programmers.co.kr/learn/courses/30/lessons/120837
public class AntArmy {
    public static void main(String[] args) {
        System.out.println(solution(23));
    }

    public static int solution(int hp) {
        int[] antArr = {5, 3, 1};
        int count = 0;

        for (int i = 0; i < antArr.length; i++) {
            count += hp/antArr[i];
            hp = hp%antArr[i];
        }

        return count;
    }
}
