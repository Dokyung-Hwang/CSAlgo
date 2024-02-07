package algorithm.solution.kimhaming.leetcode.string;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
    }

    // 리턴 타입이 없는 함수이므로 sout 출력으로 마무리 짓기
    public static void reverseString(char[] s) {
        /**
         * StringBuilder는 문자열을 변경할 때마다 새로운 객체를 생성하지 않고 내부 버퍼를 이용하여
         * 효율적으로 처리하기 때문에 문자열을 뒤집는 작업을 수행할 때에도 추가적인 메모리 할당 없이
         * 직접 버퍼 조작하여 뒤집기 가능합니다.
         */
        StringBuilder sb = new StringBuilder();
        // char형 배열 s를 String Builder에 추가하여 문자열 뒤집는다.
        sb.append(s);
        sb.reverse();
        String reversed = sb.toString();

        // 뒤집은 문자열을 다시 배열에 문자 형태로 넣어주어 출력
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed.charAt(i);
        }

        System.out.println(s);
    }
}
