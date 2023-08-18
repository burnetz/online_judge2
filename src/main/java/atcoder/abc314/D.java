package atcoder.abc314;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        int lastToUpperTime = -1;
        int lastToLowerTime = -1;

        int q = sc.nextInt();

        for(int i = 0; i < q; i++){
            int type = sc.nextInt();
            int xIndex = sc.nextInt() - 1;
            char c = sc.next().charAt(0);
            switch (type) {
                case 1 -> {
                    str[xIndex] = c;
                    time[xIndex] = i;
                }
                case 2 -> {
                    lastToLowerTime = i;
                }
                case 3 -> {
                    lastToUpperTime = i;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        //各クエリごとに常に文字の大小が反転するわけではない。
        //その文字が変更されたタイミングとtoUpper, toLowerの中でどれが一番後であるかが重要。
        for(int i = 0; i < n; i++){
            if(lastToLowerTime > lastToUpperTime && lastToLowerTime > time[i]) {
                sb.append(Character.toLowerCase(str[i]));
            }
            else if(lastToLowerTime < lastToUpperTime && lastToUpperTime > time[i]) {
                sb.append(Character.toUpperCase(str[i]));
            }
            else {
                sb.append(str[i]);
            }
        }
        System.out.println(sb);
    }
}
