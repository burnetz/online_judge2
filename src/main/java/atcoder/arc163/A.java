package atcoder.arc163;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String input = sc.next();

            if(dfs(0, input, "")){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }

    static boolean dfs(int start, String originalStr, String subStr) {
        int len = originalStr.length();

        for(int i = start + 1; i < len; i++){
            String tmpSubStr = originalStr.substring(start, i);
            if(subStr.compareTo(tmpSubStr) < 0 && dfs(i, originalStr, tmpSubStr)){
                return true;
            }
        }

        if(start > 0 && subStr.compareTo(originalStr.substring(start)) < 0){
            return true;
        }

        return false;
    }
}
