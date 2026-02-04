
package atcoder.abc442;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        int volume = 0;
        boolean isPlaying = false;
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    volume++;
                }
                case 2 -> {
                    volume = Math.max(0, volume - 1);
                }
                case 3 -> {
                    isPlaying = !isPlaying;
                }
            }

            System.out.println(volume >= 3 && isPlaying ? "Yes" : "No");
        }

    }
}