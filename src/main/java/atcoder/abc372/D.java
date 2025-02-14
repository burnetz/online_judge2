package atcoder.abc372;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int h[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int result[] = new int[n];
        result[n - 1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //新しく追加される要素未満の数字を追い出す。
        //参照するのはi番目ではなく(i+1)番目なので注意
        for(int i = n - 2; i >= 0; i--) {
            while(!pq.isEmpty() && pq.peek() < h[i + 1]) {
                pq.remove();
            }
            pq.add(h[i + 1]);
            result[i] = pq.size();
        }

        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}