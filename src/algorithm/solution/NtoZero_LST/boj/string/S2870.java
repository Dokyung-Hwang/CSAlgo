package algorithm.solution.NtoZero_LST.boj.string;

import java.util.*;
import java.io.*;

public class S2870 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int tc = Integer.parseInt(br.readLine());
//
//        List<String> list = new ArrayList<>();
//
//        for(int i=0; i<tc; i++) {
//            String str = br.readLine();
//            StringBuilder sb = new StringBuilder();
//            for(int j=0; j<str.length(); j++) {
//                char c = str.charAt(j);
//                if(Character.isDigit(c)) {
//                    sb.append(c);
//                }
//                if(j+1>=str.length() && sb.length()>0) {
//                    if(!sb.toString().equals("0"))
//                        list.add(sb.toString().replace("0", ""));
//                    else
//                        list.add(sb.toString());
//                    break;
//                }
//                if(j+1<str.length() && !Character.isDigit(str.charAt(j+1)) && sb.length()>0) {
//                    if(!sb.toString().equals("0"))
//                        list.add(sb.toString().replace("0", ""));
//                    else
//                        list.add(sb.toString());
//                    sb.setLength(0);
//                }
//            }
//        }
//
//        Collections.sort(list);
//        for(String s : list) {
//            System.out.println(s);
//        }
    }
}

/*
NumberFormatException이 발생하는 풀이 : Integer나 Value의 범위를 넘을 수 있음.

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

for(int i=0; i<tc; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(Character.isDigit(c)) {
                    sb.append(c);
                }
                if(j+1>=str.length() && sb.length()>0) {
                    list.add(Integer.valueOf(sb.toString()));
                    break;
                }
                if(j+1<str.length() && !Character.isDigit(str.charAt(j+1)) && sb.length()>0) {
                    list.add(Integer.valueOf(sb.toString()));
                    sb.setLength(0);
                }
            }
        }

        Collections.sort(list);
        for(int i : list) {
            System.out.println(i);
        }
 */