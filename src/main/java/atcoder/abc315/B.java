package atcoder.abc315;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d[] = new int[m];
        int sum[] = new int[m];

        for(int i = 0; i < m; i++){
            d[i] = sc.nextInt();
            if(i != 0){
                sum[i] = d[i - 1];
                sum[i] += sum[i - 1];
            }
        }

        int mid = (sum[m - 1] + d[m - 1])/2;
//        System.out.println(mid);

//        for(int i = 0; i < m; i++){
//            System.out.println(i + " " + sum[i]);
//        }

        for(int i = m - 1; i >= 0; i--) {
            if(sum[i] <= mid) {

//                System.out.println(i + " " + sum[i]);
                System.out.println(i + 1 + " " + (mid - sum[i] + 1));
                return;
            }
        }
    }
}
