package algorithm.solution.NtoZero_LST.boj.deque;

import algorithm.problem.baekjoon.deque.P10866;

import java.io.*;

public class S10866 implements P10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque(N);
        for(int i=0; i<N; i++) {
            String[] command = br.readLine().split(" ");
            if(command[0].startsWith("push")) {
                int x = Integer.parseInt(command[1]);
                if (command[0].endsWith("back")) {
                    deque.push_back(x);
                } else {
                    deque.push_front(x);
                }
                continue;
            }
            switch (command[0]) {
                case "front" :
                    deque.front();
                    break;
                case "back" :
                    deque.back();
                    break;
                case "size" :
                    bw.write(String.valueOf(deque.size())+"\n");
                    break;
                case "empty" :
                    deque.empty();
                    break;
                case "pop_front":
                    deque.pop_front();
                    break;
                case "pop_back":
                    deque.pop_back();
                    break;
            }
        }
            bw.close();
    }

    static class MyDeque {
        int[] arr;

        int head = 0, tail = 0;

        public MyDeque(int N) {
            this.arr = new int[N];
            head = N/2;
            tail = N/2;
        }

        public void push_front(int x) {
            if(head-1<0) widingArr();
            arr[--head] = x;
        }

        public void push_back(int x) {
            if(tail>=arr.length) widingArr();
            arr[tail++] = x;
        }

        private void widingArr() {
            int[] newArr = new int[2*arr.length];
            System.arraycopy(arr, head, newArr,head, tail-head);
            this.arr = newArr;
        }

        public int size() {
            return tail-head;
        }

        public void pop_front() throws IOException {
            //tail이 head보다 클 동안 동작
            if(head < tail){
                bw.write(String.valueOf(arr[head] == 0 ? -1 : arr[head])+"\n");
                arr[head] = 0; //덱은 양방향이므로 0 초기화
                head++;
                return;
            }
            //size == 0
            bw.write(-1+"\n");
        }

        public void pop_back() throws IOException {
            //tail이 head보다 클 동안만 동작
                                                    //tail에 -1 붙이는 것 주의
            if(head<tail) {
                bw.write(String.valueOf(arr[tail-1] == 0 ? -1 : arr[tail-1])+"\n");
                arr[tail-1] = 0; // 덱은 양방향이므로 0 초기화
                tail--;
                return;
            }
            // size ==0
            bw.write(-1+"\n");
        }

        boolean empty() throws IOException {
            if(size()==0) {
                bw.write(1+"\n");
                return true;
            }
            bw.write(0+"\n");
            return false;
        }

        public void front() throws IOException {
            if(size()==0) bw.write(-1+"\n");
            else {
                bw.write(arr[head]+"\n");
            }
        }

        public void back() throws IOException {
            if(size()==0 || tail >= arr.length) bw.write(-1+"\n");
            else {
                bw.write(arr[tail-1]+"\n");
            }
        }
    }
}
