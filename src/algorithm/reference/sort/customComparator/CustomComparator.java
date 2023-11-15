package algorithm.reference.sort.customComparator;

import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {

	// 두 객체를 전달 받아 비교할 때 사용한다.

	public static void main(String[] args) {
		People peopleA = new People(20, "홍길동");
		People peopleB = new People(23, "김길동");

		People[] peoples = new People[2];
		peoples[0] = peopleB;
		peoples[1] = peopleA;

		CustomStringComparator customStringComparator = new CustomStringComparator();
		CustomIntegerComparator customIntegerComparator = new CustomIntegerComparator();

		System.out.println(customStringComparator.compare(peopleA, peopleB));
		System.out.println(customIntegerComparator.compare(peopleA, peopleB));

		System.out.println(peoples[0].age + ", " + peoples[1].age);
		Arrays.sort(peoples, customIntegerComparator);
		System.out.println(peoples[0].age + ", " + peoples[1].age);

		System.out.println(peoples[0].name + ", " + peoples[1].name);
		Arrays.sort(peoples, customStringComparator);
		System.out.println(peoples[0].name + ", " + peoples[1].name);
	}

	private static class CustomStringComparator implements Comparator<People> {

		@Override
		public int compare(People o1, People o2) {
			return o1.name.compareTo(o2.name);
		}
	}

	private static class CustomIntegerComparator implements Comparator<People> {

		@Override
		public int compare(People o1, People o2) {
			return o1.age - o2.age;
		}
	}

	private static class People {
		int age;
		String name;

		public People(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}
