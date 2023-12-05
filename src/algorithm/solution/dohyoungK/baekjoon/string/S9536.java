package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P9536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class S9536 implements P9536 {
// TODO:
//  여러 동물의 울음소리에서 다른 울음소리를 제외하고 남은
//  여우의 울음소리 출력

// TODO:
//  hashmap에 울음소리 저장해 놓고
//  replace로 다른 동물의 울음소리 없애기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sound = new StringBuilder(br.readLine());
            HashMap<String, String> hm = new HashMap<>();

            while (true) {
                String str = br.readLine();
                if (str.equals("what does the fox say?")) break;

                String[] animalSound = str.split(" ");
                hm.put(animalSound[0], animalSound[2]);
            }

            int index = 0;
            for (String key : hm.keySet()) {
                String value = hm.get(key);

                while (true) {
                    index = sound.indexOf(value, index);

                    if (index == -1) break;
                    // 앞글자가 공백이 아니라 글자라면 무시 (울음소리 내부에 다른 울음소리가 포함되어 있을 때)
                    if (index != 0 && sound.charAt(index - 1) != ' ') {
                        index += value.length();
                        continue;
                    }
                    sound.replace(index, index + value.length() + 1, "");
                }
            }

            System.out.println(sound);
        }
    }
}
