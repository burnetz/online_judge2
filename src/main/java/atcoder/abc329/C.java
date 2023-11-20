package atcoder.abc329;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int length[] = new int[26];
        int tmpLen = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0 || str.charAt(i - 1) == str.charAt(i)) {
                tmpLen++;
                length[str.charAt(i) - 'a'] = Math.max(length[str.charAt(i) - 'a'], tmpLen);
            }
            else {
                length[str.charAt(i) - 'a'] = Math.max(length[str.charAt(i) - 'a'], 1);
                tmpLen = 1;
            }
        }
        System.out.println(Arrays.stream(length).sum());
    }
}
