package algorithm.solution.smileDK.programmers.basic;

public class RSP {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120839
    public static void main(String[] args) {
        System.out.println(solution("2"));
        System.out.println(solution("205"));
        System.out.println(solution("520"));
    }

    public static String solution (String rsp) {
        StringBuilder sb = new StringBuilder();
        final String rock = "0";
        final String scissors = "2";
        final String paper = "5";

        for (int i = 0; i < rsp.length(); i++) {
            char c = rsp.charAt(i);
            if (c == rock.charAt(0))
                sb.append(paper);

            else if (c == scissors.charAt(0))
                sb.append(rock);

            else
                sb.append(scissors);
        }

        return sb.toString();
    }
}
