package atcoder.abc307;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] input = new String[n];
        for(int i = 0; i < n; i++){
            input[i] = sc.next();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }

                String combined = input[i] + input[j];

                boolean flag = true;
                for(int k = 0; k < combined.length()/2 ; k++){
                    if(combined.charAt(k) != combined.charAt(combined.length() - k - 1)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
