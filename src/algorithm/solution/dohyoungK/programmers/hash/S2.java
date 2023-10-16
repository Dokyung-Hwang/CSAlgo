package algorithm.solution.dohyoungK.programmers.hash;

import algorithm.problem.programmers.hash.P2;

import java.util.HashMap;

public class S2 implements P2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String name : participant){
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }

        for (String name : completion){
            int value = hm.get(name) - 1;
            if(value != 0){
                hm.put(name, value);
            } else {
                hm.remove(name);
            }
        }

        return hm.keySet().iterator().next();
    }
}
