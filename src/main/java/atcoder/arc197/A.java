package atcoder.arc197;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            String s = sc.next();

            int downCount = 0;
            int rightCount = 0;
            for(int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'D' -> {
                        downCount++;
                    }
                    case 'R' -> {
                        rightCount++;
                    }
                }
            }

            //?のうち何回右に移動できるか
            int rightRemain = w - rightCount - 1;

            long white1 = 0;
            int x = 0;
            //右に行けるなら早いうちに右に行くというアプローチで
            //塗ることができない右上部分を数える。
            for(int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'R' -> {
                        x++;
                    }
                    case '?' -> {
                        if(rightRemain > 0) {
                            x++;
                            rightRemain--;
                        }
                        else {
                            white1 += w - x - 1;
                        }
                    }
                    case 'D' -> {
                        white1 += w - x - 1;
                    }
                }

                if(x == w - 1) {
                    break;
                }
            }

            long white2 = 0;
            int y = 0;

            int downRemain = h - downCount - 1;

            //下に行けるなら早いうちに下に行くというアプローチで
            //塗ることができない左下部分を数える
            for(int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'D' -> {
                        y++;
                    }
                    case '?' -> {
                        if(downRemain > 0) {
                            y++;
                            downRemain--;
                        }
                        else {
                            white2 += h - y - 1;
                        }
                    }
                    case 'R' -> {
                        white2 += h - y - 1;
                    }
                }

                if(y == h - 1) {
                    break;
                }
            }

            //上で求めた右上部分と左下部分以外のマスはやり方次第で濡れる。
            System.out.println((long) h * w - white1 - white2);
        }
    }
}
