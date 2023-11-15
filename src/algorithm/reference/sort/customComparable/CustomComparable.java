package algorithm.reference.sort.customComparable;

public class CustomComparable {
	/*
		Comparable : 자기 자신과 다른 객체를 비교할 때 사용
		즉, PeopleA와 PeopleB를 비교할 때 사용

		compareTo 메서드의 파라미터로 비교할 객체를 전달한 후에
		메서드의 바디에 비교할 방식을 코드로 구현한다.

		자기 자신을 기준으로 값이 크다면 양수
		같다명 0, 작다면 음수를 리턴 해주면 된다.
	 */

	public static void main(String[] args) {
		People peopleA = new People(20, "홍길동");
		People peopleB = new People(23, "김길동");

		System.out.println(peopleA.compareTo(peopleB));
	}

	private static class People implements Comparable<People> {

		int age;
		String name;

		public People(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(People o) {
			return this.age - o.age;
		}
	}
}
