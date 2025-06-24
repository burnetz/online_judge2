package atcoder.abc411;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        boolean isBlack[] = new boolean[n];

        int result = 0;
        for(int i = 0; i < q; i++) {
            int index = sc.nextInt() - 1;

            if(isBlack[index]) {
                if(n == 1) {
                    result--;
                }
                else if(index > 0 && index < n - 1){
                    if(isBlack[index - 1] && isBlack[index + 1]) {
                        result++;
                    }
                    else if(!isBlack[index - 1] && !isBlack[index + 1]) {
                        result--;
                    }
                }
                else if(index == 0) {
                    if(index + 1 < n && !isBlack[index + 1]) {
                        result--;
                    }
                }
                else if(index == n - 1) {
                    if(index - 1 >= 0 && !isBlack[index - 1]) {
                        result--;
                    }
                }
            }
            else {
                if(n == 1) {
                    result++;
                }
                else if(index > 0 && index < n - 1){
                    if(!isBlack[index - 1] && !isBlack[index + 1]) {
                        result++;
                    }
                    else if(isBlack[index - 1] && isBlack[index + 1]) {
                        result--;
                    }
                }
                else if(index == 0) {
                    if(index + 1 < n && !isBlack[index + 1]) {
                        result++;
                    }
                }
                else if(index == n - 1) {
                    if(index - 1 >= 0 && !isBlack[index - 1]) {
                        result++;
                    }
                }
            }

            isBlack[index] = !isBlack[index];
            System.out.println(result);
        }

    }
}