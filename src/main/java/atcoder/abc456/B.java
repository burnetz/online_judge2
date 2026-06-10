package atcoder.abc456;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] dices = new int[3][6];
        int[][] count = new int[3][7];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 6; j++) {
                dices[i][j] = sc.nextInt();
                count[i][dices[i][j]]++;
            }
        }

        int sum = 0;
        sum += count[0][4]*count[1][5]*count[2][6];
        sum += count[0][4]*count[1][6]*count[2][5];
        sum += count[0][5]*count[1][4]*count[2][6];
        sum += count[0][5]*count[1][6]*count[2][4];
        sum += count[0][6]*count[1][4]*count[2][5];
        sum += count[0][6]*count[1][5]*count[2][4];

        System.out.println(sum / 216.0);

    }
}