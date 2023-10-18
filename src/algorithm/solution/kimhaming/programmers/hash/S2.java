package algorithm.solution.kimhaming.programmers.hash;

import algorithm.problem.programmers.hash.P2;

import java.util.HashMap;

public class S2 implements P2 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    // Todo: HashMap을 사용해서 시간복잡도 줄이기
    //  getOrDefault() 메서드 : 해당 key가 존재하면 실제 value를 가져오고,
    //  존재하지 않는다면 기입한 value를 기본값으로 가져온다.
    //  participant 명단에 있는 참가자 중에 completion 명단에 있는 완주자를 제외한 한 사람을 출력해야한다.
    //  먼저, 참여자 명단 participant를 순회하며 출전하는 선수 이름을 key로 갖고, 동명이인이 없으면 value를 1
    //  동명이인이 있다면 value가 2,3, ... 증가하도록 for문 작성한다.
    //  다음으로, 완주자 명단 completion을 순회하며 map에 저장되어있는 key가 completion에 등장한다면,
    //  value를 -1 감소시킨다.
    //  동명이인까지 완주자 명단에 모두 있다면, value는 0이 될 것이다.
    //  동명이인이든 뭐든 간에 완주자 명단에 없는 사람은 value가 1 이상으로 남을 것이다.
    //  결국, 0이 아니라 그 초과된 수로 남아있다면 그 사람이 완주하지 못한 사람이므로 출력되어야 한다.
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
            return null;    // 메서드의 반환 타입을 충족하기 위해 작성 ?
        }
}
