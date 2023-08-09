package atcoder.abc313;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        long sum = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }

        long min = sum / n;
        long resultTop = 0;
        long resultBottom = 0;

        for(int i = 0; i < n ; i++){
            resultTop += Math.max(a[i] - (min + 1), 0);
            resultBottom += Math.max(min - a[i], 0);
        }
        //「埋めなければいけない量」と「削らなければいけない量」のうち大きいほうが答え
        System.out.println(Math.max(resultBottom, resultTop));
    }
}
