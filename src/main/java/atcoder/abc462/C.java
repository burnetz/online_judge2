package atcoder.abc462;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        XY[] xies = new XY[n];

        for(int i = 0; i < n; i++) {
            xies[i] = new XY(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(xies, Comparator.comparingInt(XY::x));

        int currentY = xies[0].y();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(xies[i].y() < currentY) {
                count++;
                currentY = xies[i].y();
            }
        }

        System.out.println(count);
    }
}

record XY(int x, int y){}