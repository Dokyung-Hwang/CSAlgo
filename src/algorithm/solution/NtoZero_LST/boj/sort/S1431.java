package algorithm.solution.NtoZero_LST.boj.sort;

import algorithm.problem.baekjoon.sort.P1431;

import java.util.*;
import java.io.*;

public class S1431 implements P1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Guitar[] guitars = new Guitar[N];
        for(int i=0; i<N; i++) {
            guitars[i] = new Guitar(br.readLine());
        }
        Arrays.sort(guitars);

        StringBuilder sb = new StringBuilder();
        for(Guitar g : guitars) {
            sb.append(g.serialNum+"\n");
        }
        System.out.println(sb);
    }

    public static class Guitar implements Comparable<Guitar> {
        String serialNum;
        int length;
        int numSum;

        public Guitar(String serialNum) {
            this.serialNum = serialNum;
            this.length = serialNum.length();
        }

        //TODO:
        @Override
        public int compareTo(Guitar other) {
            if (this.length != other.length) {
                return Integer.compare(this.length, other.length);
                //return this.length - other.length;
            } else if(this.length == other.length ) { // this.length == other.length
                for (Character c : this.serialNum.toCharArray()) {
                    if (Character.isDigit(c)) this.numSum += c - '0';
                }
                for (Character c : other.serialNum.toCharArray()) {
                    if (Character.isDigit(c)) other.numSum += c - '0';
                }
                if(this.numSum != other.numSum)
                    return this.numSum - other.numSum;
            }
            // this.numSum == other.numSum
//            int comp = 0;
//            for(int i=0; i<this.length; i++) {
//                if(this.serialNum.charAt(i) != other.serialNum.charAt(i)) {
//                    comp = this.serialNum.charAt(i) - other.serialNum.charAt(i);
//                    break;
//                }
//            }
            return this.serialNum.compareTo(other.serialNum);
        }
    }


//    static class Guitar implements Comparator<Guitar> {
//        String serialNum;
//        int length;
//        int numSum;
//
//        public Guitar(String serialNum) {
//            this.serialNum = serialNum;
//            this.length = serialNum.length();
//        }
//
//        @Override
//        public int compare(Guitar o1, Guitar o2) {
//            if(o1.length!=o2.length) {
//                return o1.length-o2.length;
//            } else { // o1.length == o2.length
//                for(Character c : o1.serialNum.toCharArray()) {
//                    if(Character.isDigit(c)) o1.numSum += c-'0';
//                }
//                for(Character c : o2.serialNum.toCharArray()) {
//                    if(Character.isDigit(c)) o2.numSum += c-'0';
//                }
//                return o1.numSum-o2.numSum;
//            }
//        }
//    }
}
