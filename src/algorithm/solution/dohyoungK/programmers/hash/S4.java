package algorithm.solution.dohyoungK.programmers.hash;

import algorithm.problem.programmers.hash.P4;

import java.util.*;

public class S4 implements P4 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}}));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        for (String[] arr : clothes) {
            ArrayList<String> list = hm.getOrDefault(arr[1], new ArrayList<>());
            list.add(arr[0]);
            hm.put(arr[1], list);
        }

        int sum = 1;
        for (ArrayList<String> list : hm.values()) {
            sum *= list.size() + 1;
        }
        return sum - 1;
    }
}
