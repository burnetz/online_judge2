
package atcoder.abc482;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();

        //入力された座標を単に格納するためのvector。同じ座標があれば複数回格納。
        Vector<Double> vecX = new Vector<>();
        Vector<Double> vecY = new Vector<>();

        for(int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            vecX.add((double)c);
            vecY.add((double)r);
        }

        Collections.sort(vecX);
        Collections.sort(vecY);

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch(type) {
                case 1 -> {
                    int u = sc.nextInt();
                    int d = sc.nextInt();
                    //0.5ずらすことで必ずギリギリ外すことができる。
                    int index1 = Collections.binarySearch(vecY, u - 0.5);
                    int index2 = Collections.binarySearch(vecY, d + 0.5);

                    index1 = -(index1 + 1);
                    index2 = -(index2 + 1);

                    System.out.println(index2 - index1);
                }
                case 2 -> {
                    int l = sc.nextInt();
                    int r = sc.nextInt();

                    int index1 = Collections.binarySearch(vecX, l - 0.5);
                    int index2 = Collections.binarySearch(vecX, r + 0.5);

                    index1 = -(index1 + 1);
                    index2 = -(index2 + 1);

                    System.out.println(index2 - index1);

                }
            }
        }
    }
}