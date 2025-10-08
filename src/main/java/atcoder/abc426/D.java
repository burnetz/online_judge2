package atcoder.abc426;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve (Scanner sc) {
        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();

        //i文字目より左を0に統一するためのコスト
        int leftZero[] = new int[n];
        //i文字目より左を1に統一するためのコスト
        int leftOne[] = new int[n];
        int tmpZero = 0;
        int tmpOne = 0;

        //例えば0に統一する場合、先頭もしくは末尾が1ならコスト1で除去できる。
        //戻す場所は考えず除去として良い（最も適切な場所に挿入した場合、以後コストがかからないし他への影響もない）
        //0を除去する場合は1に変換してから除去するのでコストが２かかる。
        //除去しなければならないのは1よりも外側にある0で、内側の0はそのままで良い。
        //ただしどこを中心とすれば良いかわからないためDPで最小値を計算する。
        for(int i = 0; i < n; i++) {
            if(i >= 1) {
                leftOne[i] = leftOne[i - 1];
                leftZero[i] = leftZero[i - 1];
            }

            if(str[i] == '1') {
                //0へ統一するとき、1よりも外側の0は除去に２ずつコストがかかる。
                if(i >= 1 && str[i - 1] == '0') {
                    leftZero[i] += tmpZero * 2;
                }
                leftZero[i]++;
                tmpZero = 0;
                tmpOne++;
            }
            else {
                if(i >= 1 && str[i - 1] == '1') {
                    leftOne[i] += tmpOne * 2;
                }
                leftOne[i]++;
                tmpOne = 0;
                tmpZero++;
            }
        }

        int rightZero[] = new int[n + 1];
        int rightOne[] = new int[n + 1];

        tmpZero = 0;
        tmpOne = 0;

        for(int i = n - 1; i >= 0; i--) {
            rightOne[i] = rightOne[i + 1];
            rightZero[i] = rightZero[i + 1];

            if(str[i] == '1') {
                if(i < n - 1 && str[i + 1] == '0') {
                    rightZero[i] += tmpZero * 2;
                }
                rightZero[i]++;
                tmpZero = 0;
                tmpOne++;
            }
            else {
                if(i < n - 1 && str[i + 1] == '1') {
                    rightOne[i] += tmpOne * 2;
                }
                rightOne[i]++;
                tmpOne = 0;
                tmpZero++;
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int tmpResultAllOne = leftOne[i] + rightOne[i + 1];
            int tmpResultAllZero = leftZero[i] + rightZero[i + 1];

            result = Math.min(result, Math.min(tmpResultAllOne, tmpResultAllZero));
        }

        System.out.println(result);
    }
}