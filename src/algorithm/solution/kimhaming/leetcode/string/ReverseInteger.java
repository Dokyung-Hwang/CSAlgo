package algorithm.solution.kimhaming.leetcode.string;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }   // Output -> -321

    public static int reverse(int x) {
        String str = Integer.toString(x);

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String reversedStr = sb.toString();

        try {
            int result = Integer.parseInt(reversedStr);

            if (x < 0) {
                return -result;
            } else {
                return result;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
