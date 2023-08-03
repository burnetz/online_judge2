package atcoder.abc302;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long d = sc.nextLong();

        long a[] = new long[n];
        long b[] = new long[m];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }

        for(int i = 0; i < m; i++){
            b[i] = sc.nextLong();
        }

        Arrays.sort(b);

        long result = -1;
        //a[i]+d以下で最大のb[j]を探すのが最適。それを下回る価値の場合は解になりえない。
        //2分探索なら間に合う。
        for(int i = 0; i < n; i++) {
            int indexR = index(a[i] + d, b, true);
            if(indexR >= 0 && b[indexR] >= a[i] - d) {
                result = Math.max(result, a[i] + b[indexR]);
            }
        }
        System.out.println(result);
    }

    static int index(long value, long array[], boolean lower){
        int index = Arrays.binarySearch(array, value);

        if(index < 0){
            index++;
            index *= -1;
            if(lower) {
                index--;
            }
        }

        return index;
    }
}
