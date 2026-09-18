package atcoder.arc225;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(sc.nextInt());
        }
        String[] strArray = sb.toString().split("0");

        //1が全く無い場合はBobの勝ち
        if(strArray.length == 0) {
            System.out.println("Bob");
            return;
        }

        //AliceがBobに勝つ方法は最初のターンで1を全て長さ2のブロックにすること。
        //長さが1のときは0にすれば良いし、長さが3以上のときは適切な操作で長さがちょうど2のブロック複数個に分割できる。
        //逆に、元々全てが長さ2のブロックだった場合必ずどれかが長さ1になってしまい
        //Bobが次のターンに上記の戦術を使うため詰む。
        for(int i = 0; i < strArray.length; i++) {
            if(!strArray[i].isEmpty() && strArray[i].length() != 2) {
                System.out.println("Alice");
                return;
            }
        }

        System.out.println("Bob");
    }
}