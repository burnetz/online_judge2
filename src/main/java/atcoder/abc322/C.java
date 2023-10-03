package atcoder.abc322;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        for(int i = 1; i <= n; i++) {
            int index = Arrays.binarySearch(a, i);

            if(index >= 0) {
                System.out.println(0);
            }
            else {
                index = (index + 1) * (-1);
                System.out.println(a[index] - i);
            }
        }
    }
}
