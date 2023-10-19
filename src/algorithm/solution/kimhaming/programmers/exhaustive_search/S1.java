package algorithm.solution.kimhaming.programmers.exhaustive_search;

public class S1 {
    //  https://velog.io/@haminggu/프로그래머스Java-완전탐색-최소-직사각형
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));    // 배열 타입은 안 써도 된다.
    }
    //  Todo: 가로 중 최댓값, 세로 중 최댓값 추출하여 최소 직사각형 크기 구하기
    //  1. [가로, 세로]를 원소로 갖는 2차원 배열 sizes 가 주어진다.
    //  2. 가로 > 세로가 되도록 정렬 -> 값 비교하여 더 큰 값을 가로에 담고, 작은 값을 세로에 담기
    //  3. 가로 중 가장 큰 값을 가로 변수에 저장, 세로 중 가장 큰 값을 세로 변수에 저장
    //  4. 가로 * 세로 리턴
    public static int solution(int[][] sizes) {
        int answer = 0;
        int max_width = 0;
        int max_height = 0;

        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            max_width = Math.max(max_width, width);
            max_height = Math.max(max_height, height);
        }
        answer = max_width * max_height;

        return answer;
    }
}
