package atcoder.abc372;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        char[] str = sc.next().toCharArray();

        int count = 0;
        for(int i = 0; i < n - 2; i++) {
            if(str[i] == 'A' && str[i + 1] == 'B' && str[i + 2] == 'C') {
                count++;
            }
        }

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt() - 1;
            char c = sc.next().charAt(0);

            boolean includeABC = false;
            for(int j = Math.max(0, x - 2) ; j < Math.min(n, x + 3) - 2 ; j++) {
                if(str[j] == 'A' && str[j + 1] == 'B' && str[j + 2] == 'C') {
                    includeABC = true;
                    break;
                }
            }

            str[x] = c;

            boolean includeABC2 = false;
            for(int j = Math.max(0, x - 2) ; j < Math.min(n, x + 3) - 2 ; j++) {
                if(str[j] == 'A' && str[j + 1] == 'B' && str[j + 2] == 'C') {
                    includeABC2 = true;
                    break;
                }
            }

            if(includeABC && !includeABC2) {
                count--;
            }
            else if(!includeABC && includeABC2) {
                count++;
            }

            System.out.println(count);

        }
    }
}