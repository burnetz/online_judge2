package atcoder.abc416;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();
            int b[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = 0; j < n; j++) {
                pq.add(b[j]);
            }
            long result = 0;

            //Aについて降順に見ていき、A[i]+B[i]がギリギリM以上になるB[i]を探す。
            //そのときのB[i]未満の数字はこの先もA[i]を打ち消すことが無いため
            //modと無関係に後から足すしかない。
            for(int j = n - 1; j >= 0; j--) {
                boolean hit = false;
                while (!pq.isEmpty()) {
                    int tmp = pq.remove();

                    if(a[j] + tmp >= m) {
                        result += (a[j] + tmp) % m;
                        hit = true;
                        break;
                    }

                    //選ばれなかったB[i]も忘れずに加算
                    result += tmp;
                }

                //打ち消しに失敗したA[i]も忘れずに加算
                if(!hit) {
                    result += a[j];
                }
            }

            System.out.println(result);
        }
    }
}