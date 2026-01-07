package atcoder.abc437;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int n = sc.nextInt();

        int rowNumber[] = new int[91];
        Arrays.fill(rowNumber, -1);

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                rowNumber[sc.nextInt()] = i;
            }
        }

        int count[] = new int[h];
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();

            if(rowNumber[tmp] >= 0){
                count[rowNumber[tmp]]++;
            }
        }

        System.out.println(Arrays.stream(count).max().getAsInt());
    }
}