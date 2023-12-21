package atcoder.abc198;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            str[i] = sc.next();

            for(int j = 0; j < str[i].length(); j++) {
                String sub = str[i].substring(j, j + 1);
                if(!alphabet.contains(sub)) {
                    alphabet.add(sub);
                }
            }
        }

        //数字の重複を許さないのでアルファベットが10種類を超えるときは解なし。
        if(alphabet.size() > 10) {
            System.out.println("UNSOLVABLE");
            return;
        }

        used = new boolean[10];
        digit = new int[alphabet.size()];

        dfs(0, alphabet.size());

        System.out.println("UNSOLVABLE");
    }

    static boolean used[];
    static int digit[];
    static String str[] = new String[3];
    static Vector<String> alphabet = new Vector<>();

    //解答が存在するときはアルファベットが10種類以下。
    //重複は無いので10!パターン全て試すことができる。
    static void dfs(int currentDepth, int typesOfAlphabet) {
        if(currentDepth == typesOfAlphabet) {
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < typesOfAlphabet; i++) {
                map.put(alphabet.get(i), digit[i]);
            }
            String digitStr1 = makeDigitsStr(str[0], map);
            String digitStr2 = makeDigitsStr(str[1], map);
            String digitStr3 = makeDigitsStr(str[2], map);

            if(digitStr1.charAt(0) == '0' || digitStr2.charAt(0) == '0' || digitStr3.charAt(0) == '0') {
                return;
            }

            long num1 = Long.parseLong(digitStr1);
            long num2 = Long.parseLong(digitStr2);
            long num3 = Long.parseLong(digitStr3);

            if(num1 + num2 == num3) {
                System.out.println(num1);
                System.out.println(num2);
                System.out.println(num3);
                System.exit(0);
            }

            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(used[i]) {
                continue;
            }

            used[i] = true;
            digit[currentDepth] = i;
            dfs(currentDepth + 1, typesOfAlphabet);
            used[i] = false;
        }
    }

    static String makeDigitsStr(String str, HashMap<String, Integer> map) {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            result.append(map.get(str.substring(i, i + 1)));
        }

        return result.toString();
    }

}
