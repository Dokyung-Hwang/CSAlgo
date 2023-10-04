package algorithm.solution.da9dac.array;

import algorithm.problem.array.Arr01;

public class ArrSolution01 implements Arr01 {
	// https://da9dac.tistory.com/161
	public static void main(String[] args) {

		int[] numbers = {1, 23, 53, 77, 60};
		int[] save = new int[101];

		for (int number : numbers) {

			if (save[100 - number] == 1 || number == 100) {
				System.out.println(1);
				return;
			}
			save[number] = 1;
		}

		System.out.println(0);
	}
}
