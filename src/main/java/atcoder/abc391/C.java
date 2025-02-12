package atcoder.abc391;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int nest[] = new int[n];
        int position[] = new int[n];
        int multi = 0;

        for(int i = 0; i < n; i++) {
            position[i] = i;
            nest[i] = 1;

        }

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int p = sc.nextInt() - 1;
                    int h = sc.nextInt() - 1;
                    nest[position[p]]--;
                    if(nest[position[p]] == 1) {
                        multi--;
                    }

                    position[p] = h;
                    nest[h]++;
                    if(nest[h] == 2) {
                        multi++;
                    }
                }
                default -> {
                    System.out.println(multi);
                }
            }
        }
    }
}