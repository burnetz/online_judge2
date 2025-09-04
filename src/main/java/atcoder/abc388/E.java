package atcoder.abc388;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        boolean used[] = new boolean[n];
        int result = 0;
        int from = (n + 1) / 2;

        //理想的なのは前半分と後ろ半分で全てマッチングすること。
        //そのため、小さい方の餅は前半分からのみ選べば良い。
        for(int i = 0; i < n / 2; i++) {
            if(used[i]) {
                continue;
            }
            //同様に、大きい方の餅は少なくとも後半であり
            //なおかつ探索すべき範囲は徐々に狭くなる。
            int index = lowerBound(a, 2 * a[i], from);

            if(index < 0) {
                index++;
                index *= -1;
            }

            if(index >= n) {
                break;
            }

            result++;
            from = index + 1;
            used[index] = true;
        }

        System.out.println(result);

    }

    static int lowerBound (int[] a, int key, int from) {
        int index = Arrays.binarySearch(a, from, a.length, key);

        if(index < 0) {
            return index;
        }

        for(int i = index; i > from; i--) {
            if(a[i] != a[i - 1]) {
                index = i;
                break;
            }
        }

        return index;
    }
}