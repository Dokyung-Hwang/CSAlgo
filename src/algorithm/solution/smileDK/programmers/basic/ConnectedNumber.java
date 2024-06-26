package algorithm.solution.smileDK.programmers.basic;

public class ConnectedNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181928
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,4,5,2,1}));
        System.out.println(solution(new int[]{5,7,8,3}));
    }

    public static int solution(int[] num_list) {
        int sum = 0;
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for(int i = 0; i < num_list.length; i++){
            // 홀수
            if(num_list[i] % 2 != 0){
                odd.append(num_list[i]);
            }
            // 짝수
            else
                even.append(num_list[i]);
        }

        sum = Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());

        return sum;
    }
}
