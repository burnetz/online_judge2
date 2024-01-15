package atcoder.abc336;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String result = "L";
        for(int i = 0; i < n; i++) {
            result += "o";
        }
        System.out.println(result + "ng");
    }
}
