package atcoder.abc328;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        System.out.println(Arrays.stream(new int[n]).map(e -> sc.nextInt()).filter(e -> e <= x).sum());
    }
}
