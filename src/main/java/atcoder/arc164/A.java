package atcoder.arc164;

import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            Vector<Long> powers = new Vector<Long>();
            long tmp = 1;
            while(tmp <= n){
                powers.add(tmp);
                tmp *= 3;
            }

            long count = 0;
            //一旦kの制約を無視して最低いくつの項があれば作れるか考える
            for(int j = powers.size() - 1; j >= 0; j--){
                long a = powers.get(j);
                count += n / a;
                n %= a;
            }

            //上で求めた項数がkより大きい場合は不可。
            //それより小さい場合は3^mを3^(m+1) + 3^(m+1) + 3^(m+1)に崩すことによって項数を増やせる。
            //その場合でも項数の偶奇は変えられない。
            if(count % 2 == k % 2 && count <= k){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}
