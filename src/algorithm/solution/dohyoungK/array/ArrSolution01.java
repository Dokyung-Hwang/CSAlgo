package algorithm.solution.dohyoungK.array;

import algorithm.problem.array.Arr01;

import java.util.HashMap;
import java.util.Map;

public class ArrSolution01 implements Arr01 {
    public static void main(String[] args) {
        /*
		int[] arr = {1, 23, 53, 77, 60};
		위와 같은 배열이 주어졌을 때
		두 수를 합해서 100이 되는 배열이면 1
		아니면 0을 반환하기
	 */
        int[] arr = {1, 23, 53, 77, 60};
        Map<Integer, Boolean> hm = new HashMap<>();

        for (int num : arr) {
            hm.put(num, true);
        }

        for (int num : arr) {
            if (hm.getOrDefault(100 - num, false)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
