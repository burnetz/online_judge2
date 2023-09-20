package atcoder.abc320;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int result = 0;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j <= str.length(); j++) {
                String subStr = str.substring(i, j);
                String reverseStr = new StringBuffer(subStr).reverse().toString();

                if(subStr.equals(reverseStr)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        System.out.println(result);

    }
}
