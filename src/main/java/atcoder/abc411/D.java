package atcoder.abc411;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        Query[] queries = new Query[q];
        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int target = sc.nextInt();

            switch (type) {
                case 1, 3 -> {
                    queries[i] = new Query(type, target);
                }
                case 2 -> {
                    queries[i] = new Query(type, target, sc.next());
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        int nextPC = 0;

        //敢えて逆順に処理することで最終的に結果に影響しない処理を無視することができる。
        //各PCの各時点での文字列を保存する必要もなくなる。
        for(int i = q - 1; i >= 0; i--) {
            switch (queries[i].type) {
                case 1 -> {
                    //フォーカスしているPCのときだけフォーカスをサーバーに移す。
                    //それ以外のときは結果に影響しないので何もしなくて良い。
                    if(queries[i].target == nextPC) {
                        nextPC = 0;
                    }

                }
                case 2 -> {
                    if(queries[i].target == nextPC) {
                        sb = sb.append(new StringBuffer(queries[i].str).reverse());
                    }
                }
                case 3 -> {
                    if(nextPC == 0) {
                        nextPC = queries[i].target;
                    }
                }
            }
        }

        System.out.println(sb.reverse());
    }
}

class Query {
    int type;
    int target;
    String str;

    Query (int type, int target) {
        this(type, target, "");
    }

    Query (int type, int target, String str) {
        this.type = type;
        this.target = target;
        this.str = str;
    }
}