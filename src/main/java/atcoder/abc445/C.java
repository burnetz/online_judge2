package atcoder.abc445;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        result = new int[n];

        for(int i = 0; i < n; i++) {
            if(result[i] == 0) {
                dfs(i, a);
            }
            System.out.print(result[i] + " ");
        }

    }

    static int[] result;

    //問題の制約上インデックスは大きくなる一方なのでどこから始めても必ず自己ループに到達する。
    static int dfs(int index, int[] a) {
        if(a[index] - 1 == index) {
            result[index] = index + 1;
            return index + 1;
        }

        int tmp = dfs(a[index] - 1, a);
        result[index] = tmp;
        return tmp;
    }
}