package algorithm.solution.dohyoungK.leetcode.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        boolean chk = false;

        LOOP:
        for (int i = 0; i < strs[0].length(); i++) {
            prefix = strs[0].substring(0, i + 1);

            for (String str : strs) {
                if (str.indexOf(prefix) != 0) {
                    chk = true;
                    break LOOP;
                }
            }
        }

        if (chk) return prefix.substring(0, prefix.length() - 1);
        return prefix;
    }
}
