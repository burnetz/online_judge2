package atcoder.abc432;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int data = sc.nextInt();
        char[] chars = Integer.toString(data).toCharArray();

        Arrays.sort(chars);
        boolean started = false;
        int zeroCount = 0;

        String result = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != '0') {
                started = true;
                result += chars[i];
            }
            else {
                zeroCount++;
            }

            if(started) {
                while(zeroCount > 0) {
                    result += 0;
                    zeroCount--;
                }


            }
        }

        System.out.println(result);

    }

}