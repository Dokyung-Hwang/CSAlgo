package algorithm.solution.NtoZero_LST.boj.queue;

import algorithm.problem.baekjoon.queue.P18258;

import java.io.*;

public class S18258 implements P18258 {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        MyQueue queue = new MyQueue(N);

        for(int i=0; i<N; i++) {
            String[] command = br.readLine().split(" ");
            if(command[0].equals("push")) {
                queue.push(Integer.parseInt(command[1]));
                continue;
            }
            switch (command[0]) {
                case "front" :
                    queue.front();
                    break;
                case "back" :
                    queue.back();
                    break;
                case "size" :
                    queue.size();
                    break;
                case "pop" :
                    queue.pop();
                    break;
                case "empty" :
                    queue.empty();
            }
        }
        bw.close();
    }
    static class MyQueue {
        int[] data;
        int head = 0; // 가장 앞에 있는 인덱스
        int tail = 0; // 가장 뒤에 있는 원소 인덱스 +1

        public MyQueue(int N) {
            this.data = new int[N];
        }

        public void push(int x) {
            data[tail++] = x;
        }

        public void pop() throws IOException {
            if(data[head] == 0) bw.write(String.valueOf(-1) +"\n");
            else {
                bw.write(String.valueOf(data[head]+"\n"));
                head++;
            }
        }

        public void size() throws IOException {
            bw.write(String.valueOf(tail-head)+"\n");
        }

        public void empty() throws IOException {
            int num = 0;
            int size = tail-head;
            if(size==0) num = 1;

            bw.write(String.valueOf(num)+"\n");
        }

        public void front() throws IOException {
            bw.write(String.valueOf(data[head] == 0 ? -1 : data[head])+"\n");
        }

        public void back() throws IOException {
            //ArrayOutOfIndex 예외 조건 추가
            if(tail-1 <0) bw.write(-1+"\n");
            else                                                //size 조건 추가 (tail-head)가 0인 경우
                bw.write(String.valueOf(data[tail-1] == 0 || tail-head ==0 ? -1 : data[tail-1])+"\n");
        }
    }
}
/*
 back()에서 size 조건을 추가해주어야 하는 이유:

 8
push 100
pop
empty
pop
size
empty // 분명히 비어 있는 큐인데
back  // 100이 나올 수 있다. (size==0 조건이 없다면)
front
 */
