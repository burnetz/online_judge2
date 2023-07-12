package atcoder.abc302;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        used = new boolean[n];
        strArray = new String[n];
        index = new int[n];

        for(int i = 0; i < n; i++){
            strArray[i] = sc.next();
        }

        dfs(0);
        System.out.println("No");
    }

    static boolean used[];
    static String strArray[];
    static int index[];

    /*文字列の数が少ないので全探索で十分間に合う。*/
    static void dfs(int currentDepth){
        if(currentDepth == strArray.length){
            for(int i = 0; i < index.length - 1; i++){
                int count = 0;
                for(int j = 0; j < strArray[i].length(); j++){
                    if(strArray[index[i]].charAt(j) != strArray[index[i + 1]].charAt(j)){
                        count++;
                    }
                }
                if(count != 1){
                    return;
                }
            }

            System.out.println("Yes");
            System.exit(0);
        }

        for(int i = 0; i < used.length; i++){
            if(!used[i]){
                used[i] = true;
                index[currentDepth] = i;
                dfs(currentDepth + 1);
                used[i] = false;
            }
        }
    }
}
