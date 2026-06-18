package atcoder.abc423;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] locked = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int openFirst = n;
        for(int i = 0; i < n; i++) {
            if(locked[i] == 0) {
                openFirst = i;
                break;
            }
        }

        int openLast = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(locked[i] == 0) {
                openLast = i;
                break;
            }
        }

        if(openLast == -1) {
            System.out.println(0);
            return;
        }

        int countL = 1;
        if(openFirst >= r) {
            countL = 0;
        }

        for(int i = r - 1; i > openFirst; i--) {
            if(locked[i] == 0) {
                countL++;
            }
            else {
                countL += 2;
            }
        }

        int countR = 1;
        if(openLast < r) {
            countR = 0;
        }
        for(int i = r ; i < openLast; i++) {
            if(locked[i] == 0) {
                countR++;
            }
            else {
                countR += 2;
            }
        }

        System.out.println(countL + countR);

    }
}