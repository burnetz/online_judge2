package atcoder.abc315;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(Arrays.stream(str.split("[aeiou]")).collect(Collectors.joining()));
    }
}
