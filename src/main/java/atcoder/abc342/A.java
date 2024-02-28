package atcoder.abc342;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();

        int counter[] = new int[26];

        for(int i = 0; i < str.length; i++) {
            counter[str[i] - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(counter[i] == 1) {
                for(int j = 0; j < str.length; j++) {
                    if(str[j] == 'a' + i) {
                        System.out.println(j + 1);
                        return;
                    }
                }
            }
        }


    }
}