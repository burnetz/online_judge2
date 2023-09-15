package atcoder.agc064;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println("2 1 2");
            return;
        }

        //例えばN=5のときは1 2 3, 5 4 5 4 5 4 5 4 5, 3 2 3
        //まずはN-2まで単調増加し、そこからは波打つように大きい方の数字を消化する。
        //Nが偶数か奇数かによって2で終わるか3で終わるかが変わる。
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n - 2; i++) {
            sb.append(i + " ");
        }

        for(int i = n; i >= 3; i -= 2) {
            //最上部以外は1回分減らす。最初の上りの箇所で1回使っているため。
            int times = i == n ? i : i - 1;
            for(int j = 0; j < times; j++) {
                sb.append(i + " ");
                if(j < times - 1) {
                    sb.append((i - 1) + " ");
                }
            }
        }

        if(n % 2 == 0) {
            sb.append(2 + " ");
        }
        System.out.println(sb);
    }
}
