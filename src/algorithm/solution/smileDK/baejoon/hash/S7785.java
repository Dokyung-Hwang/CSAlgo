package algorithm.solution.smileDK.baejoon.hash;

import algorithm.problem.baekjoon.hash.P7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S7785 implements P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            hashMap.put(line[0], line[1]);
        }

        // Entry 객체를 요소로 가지는 Set 생성
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();

        // entrySet을 순회하기 위한 Iterator

        ArrayList<String> nameList = new ArrayList<>();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (Objects.equals(value, "enter")) {
                nameList.add(key);
            }
        }

        nameList.sort(Collections.reverseOrder());

        for (String s : nameList) {
            System.out.println(s);
        }
    }
}
