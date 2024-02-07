package algorithm.solution.dohyoungK.leetcode.string;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "asdbutsd";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
