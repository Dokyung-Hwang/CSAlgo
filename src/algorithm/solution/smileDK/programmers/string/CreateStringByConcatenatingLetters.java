package algorithm.solution.smileDK.programmers.string;

public class CreateStringByConcatenatingLetters {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181915?language=java
    public static void main(String[] args) {
        int[] index_list1 = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
        System.out.println(solution("cvsgiorszzzmrpaqpe", index_list1));
    }

    public static String solution(String my_string, int[] index_list) {
        char[] myString = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < index_list.length; i++) {
            sb.append(myString[index_list[i]]);
        }

        return sb.toString();
    }
}
