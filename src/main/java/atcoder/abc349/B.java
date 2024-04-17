package atcoder.abc349;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int count[] = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for(int i = 1; i <= 100; i++) {
            int finalI = i;
            long tmp = Arrays.stream(count).filter(e -> e == finalI).count();

            if(tmp != 0 && tmp != 2) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}