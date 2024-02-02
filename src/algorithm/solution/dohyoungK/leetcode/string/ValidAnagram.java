package algorithm.solution.dohyoungK.leetcode.string;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    // 단어 s를 재배열해 t를 만들수 있는가
    public static boolean isAnagram(String s, String t) {
        HashMap<String, Integer> sHm = new HashMap<>();
        HashMap<String, Integer> tHm = new HashMap<>();

        if (s.length() != t.length()) return false;

        for (String key : s.split("")) {
            int value = sHm.getOrDefault(key, 0);
            sHm.put(key, value + 1);
        }

        for (String key : t.split("")) {
            int value = tHm.getOrDefault(key, 0);
            tHm.put(key, value + 1);
        }

        for (String key : s.split("")) {
            int sValue = sHm.get(key);
            int tValue = tHm.getOrDefault(key, 0);

            if (sValue != tValue) return false;
        }

        return true;
    }
}
