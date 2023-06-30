package atcoder.abc301;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        int count1[] = new int[26];
        int count2[] = new int[26];
        int wild1 = 0;
        int wild2 = 0;

        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != '@'){
                count1[str1.charAt(i) - 'a']++;
            }
            else {
                wild1++;
            }
            if(str2.charAt(i) != '@'){
                count2[str2.charAt(i) - 'a']++;
            }
            else {
                wild2++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(count1[i] > count2[i]){
                if(!isAtcoder(i)){
                    System.out.println("No");
                    return;
                }
                wild2 -= count1[i] - count2[i];
            }
            else if(count1[i] < count2[i]){
                if(!isAtcoder(i)){
                    System.out.println("No");
                    return;
                }
                wild1 -= count2[i] - count1[i];
            }

            if(wild1 < 0 || wild2 < 0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    static boolean isAtcoder(int c) {
        return "atcoder".contains("" + (char)(c + 'a'));
    }
}
