package atcoder.arc162;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();

            int a[] = new int[n];

            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }

            int count = 0;

            for(int j = 0; j < n ; j++){
                //逆転負けかどうか
                boolean flag = false;
                for(int k = j + 1; k < n; k++){
                    //往路で勝っていたにもかかわらず逆転負けした人は復路の区間賞は取れない。
                    //それ以外の人はチャンスがある。
                    if(a[k] < a[j]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
