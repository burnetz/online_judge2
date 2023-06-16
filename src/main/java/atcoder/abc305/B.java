package atcoder.abc305;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int index1 = sc.next().charAt(0) - 'A';
        int index2 = sc.next().charAt(0) - 'A';

        int pos[] = {0,3,4,8,9,14,23};

        System.out.println(Math.abs(pos[index1] - pos[index2]));
    }
}
