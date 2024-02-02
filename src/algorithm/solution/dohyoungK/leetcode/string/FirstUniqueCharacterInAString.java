package algorithm.solution.dohyoungK.leetcode.string;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String key : s.split("")) {
            int value = hm.getOrDefault(key, 0);
            hm.put(key, value + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            if (hm.get(key) == 1) return i;
        }

        return -1;
    }
}
