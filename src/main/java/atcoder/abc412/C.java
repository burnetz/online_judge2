package atcoder.abc412;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

loop:        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

            //最初と最後は固定なのでそれ以外をソートする。
            Arrays.sort(a, 1, n - 1);

            int prevIndex = 0;
            int count = 2;
            //内側はソート済みなので基本的には倒せるギリギリのドミノを選んで倒す。
            //バイナリサーチを使用可能。
            while(true) {
                int index = Arrays.binarySearch(a, 1, n, a[prevIndex] * 2);

                if(index < 0) {
                    index = -(index + 1) - 1;
                }

                //追加しなくても最後のドミノを倒せるパターン
                if(a[prevIndex] * 2 >= a[n - 1]) {
                    break;
                }
                //サイズアップが望めなくなるパターン
                else if(a[prevIndex] == a[index]) {
                    System.out.println(-1);
                    continue loop;
                }
                else {
                    prevIndex = index;
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}