package algorithm.solution.smileDK.programmers.hash;

import java.util.HashMap;

public class sample {
    public static void main(String[] args) {
        String[] s = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "abc", "abc"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : s) {
            map.put(str, map.getOrDefault(str, 0) + 2);

        }

        System.out.println(map);
    }
}
