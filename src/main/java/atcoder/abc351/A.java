package atcoder.abc351;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.stream(new int[9]).map(e->sc.nextInt()).sum()
         - Arrays.stream(new int[8]).map(e-> sc.nextInt()).sum() + 1);

    }
}