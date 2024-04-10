package atcoder.abc347;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        long c = sc.nextLong();

        String binaryC = Long.toBinaryString(c);

        while(binaryC.length() < 60) {
            binaryC = "0" + binaryC;
        }

        char aChar[] = new char[60];
        char bChar[] = new char[60];

        Arrays.fill(aChar, '0');
        Arrays.fill(bChar, '0');

        for(int i = 0; i < binaryC.length(); i++) {
            //Cのビットが1のところはAとBのうちいずれか一方のみが1になる。
            //後の工程でAとBに使える1の個数が等しくないといけないので
            //より余っている方を優先して使う。
            if(binaryC.charAt(i) == '1') {
                //途中で1を作れなくなったら不可
                if(a == 0 && b == 0) {
                    System.out.println(-1);
                    return;
                }
                if(a >= b) {
                    aChar[i] = '1';
                    a--;
                }
                else {
                    bChar[i] = '1';
                    b--;
                }
            }
        }

        //上記の工程を終えて使える1の個数が異なるときは不可能
        if(a != b) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < binaryC.length() && a > 0 && b > 0 ; i++) {
            //Cのビットが0のところならどこでも良いので前から使っていく。
            if(binaryC.charAt(i) == '0') {
                aChar[i] = '1';
                bChar[i] = '1';
                a--;
                b--;
            }
        }

        //1を使い切れなかったら不可
        if(a > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(Long.parseLong(new String(aChar), 2) + " " + Long.parseLong(new String(bChar), 2));
    }
}