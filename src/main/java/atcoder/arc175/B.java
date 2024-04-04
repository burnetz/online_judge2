package atcoder.arc175;

import java.util.*;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();

        String str = sc.next();

        //貪欲法で考える。左から見ていって(よりも)が多くなったときには
        //)を(に書き換えなければならない。
        //一旦一文字ずつの書き換えのみを仮定してスワップは考えない。
        int leftToRight = 0;
        //最終的に(が余ったらそのうちの一部を)にしなければならない。
        int rightToLeft = 0;
        int leftStock = 0;

        for(int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(' -> {
                    leftStock++;
                }
                case ')' -> {
                    if(leftStock > 0) {
                        leftStock--;
                    }
                    else {
                        rightToLeft++;
                        leftStock++;
                    }
                }
            }
        }

        leftToRight = leftStock / 2;

        long total = 0;

        int diff = Math.abs(leftToRight - rightToLeft);
        //スワップと1文字書き換え2回のどちらが得かを考える。
        if(a < 2*b) {
            total = diff * b + Math.min(leftToRight, rightToLeft) * a;
        }
        else {
            total = (leftToRight + rightToLeft) * b;
        }
        System.out.println(total);
    }


}
