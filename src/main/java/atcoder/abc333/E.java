package atcoder.abc333;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //ポーションの個数および拾ったタイミングを管理
        Stack<Integer> stacks[] = new Stack[n];
        for(int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
        }

        int[] eventType = new int[n];

        for(int i = 0; i < n; i++) {
            int mode = sc.nextInt();
            eventType[i] = mode;
            int x = sc.nextInt() - 1;

            //一旦全てのポーションを拾う前提で考える
            if(mode == 1) {
                stacks[x].push(i);
            }
            else {
                if(stacks[x].isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                //なるべく直近で拾ったポーションを使う。
                else {
                    stacks[x].pop();
                }
            }
        }

        int actionType[] = new int[n];
        Arrays.fill(actionType, 1);

        //最後までスタック内に残ったポーションは本来拾わなくても良かったものなので無視。
        for(int i = 0; i < n; i++) {
            while(!stacks[i].isEmpty()) {
                actionType[stacks[i].pop()] = 0;
            }
        }

        //上記で作成したフラグをもとに行動を再現し最大数を計算する。
        int maxPotions = 0;
        int currentPotions = 0;
        for(int i = 0; i < n; i++) {
            if(eventType[i] == 1 && actionType[i] == 1) {
                currentPotions++;
            }
            else if(eventType[i] == 2){
                currentPotions--;
            }
            maxPotions = Math.max(maxPotions, currentPotions);
        }

        System.out.println(maxPotions);
        for(int i = 0; i < n; i++) {
            if(eventType[i] == 1) {
                System.out.print(actionType[i] + " " );
            }
        }
    }
}
