package algorithm.solution.kimhaming.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S7785 implements P7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> checkList = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status= st.nextToken();
            if(checkList.containsKey(name)) {
                checkList.remove(name);
            }else {
                if(status.equals("enter")){
                    checkList.put(name, 1);
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        List<String> curList = new ArrayList<>(checkList.keySet());
        Collections.sort(curList,(a,b) -> b.compareTo(a));
        for(String s : curList) {
            sb.append(s+"\n");
        }
        System.out.println(sb.toString());
    }
}
