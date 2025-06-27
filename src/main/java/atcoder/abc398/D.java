package atcoder.abc398;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();

        String s = sc.next();

        //煙が発生した座標をメモする。
        Set<String> set = new HashSet<>();
        set.add("0,0");

        int fireR = 0;
        int fireC = 0;
        //実際には煙は原点で発生するが、
        //煙は動かずに焚き火と観測者が動くと考える。
        //こうすれば煙の座標を計算せずに済むので計算量が増えない。
        for(int i = 0; i < s.length(); i++) {
            char dir = s.charAt(i);

            switch (dir) {
                case 'N' -> {
                    r++;
                    fireR++;
                }
                case 'E' -> {
                    c--;
                    fireC--;
                }
                case 'W' -> {
                    c++;
                    fireC++;
                }
                case 'S' -> {
                    r--;
                    fireR--;
                }
            }

            String str = r + "," + c;
            if(set.contains(str)) {
                System.out.print(1);
            }
            else {
                System.out.print(0);
            }

            String fireStr = fireR + "," + fireC;
            set.add(fireStr);
        }
    }
}