package atcoder.abc354;

import java.util.*;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        Vector<Card2> cards = new Vector<>();
        for(int i = 0; i < n; i++) {
            cards.add(new Card2(a[i], b[i]));
        }

        int result = dfs(cards, 0);

        if(result == T_WIN) {
            System.out.println("Takahashi");
        }
        else if (result == A_WIN) {
            System.out.println("Aoki");
        }
        else {
            int x = 1/0;
        }
    }

    static final int T_WIN = 0;
    static final int A_WIN = 1;

    //その場に残っているカードによって勝敗が決まるので
    //明らかになったものについてはメモを残す。
    static Map<String, Integer> history = new HashMap<>();

    static int dfs(Vector<Card2> cards, int depth) {
        boolean takahashiTurn = depth % 2 == 0;

        String vecStr = vecToString(cards);

        //今の状態に対する勝敗が既に分かっている場合
        if(history.containsKey(vecStr)) {
            return history.get(vecStr);
        }

        int pairA = pair(cards, false);
        int pairB = pair(cards, true);

        //表にも裏にもペアがない場合は敗北が確定する。
        if(pairA == 0 && pairB == 0) {
            if(takahashiTurn) {
                return A_WIN;
            }
            else {
                return T_WIN;
            }
        }

        //裏にしかペアが無い場合も勝敗が確定する。
        if(pairA == 0) {
            if(pairB % 2 == 1) {
                if(takahashiTurn) {
                    return T_WIN;
                }
                else {
                    return A_WIN;
                }
            }
            else {
                if(takahashiTurn) {
                    return A_WIN;
                }
                else {
                    return T_WIN;
                }
            }
        }

        //表にしかペアが無い場合
        if(pairB == 0) {
            if(pairA % 2 == 1) {
                if(takahashiTurn) {
                    return T_WIN;
                }
                else {
                    return A_WIN;
                }
            }
            else {
                if(takahashiTurn) {
                    return A_WIN;
                }
                else {
                    return T_WIN;
                }
            }
        }

        //どのカードを抜くかは全パターン試せる。
        for(int i = 0; i < cards.size(); i++) {
            for(int j = i + 1; j < cards.size(); j++) {
                Card2 card1 = cards.get(i);
                Card2 card2 = cards.get(j);

                if(card1.a != card2.a && card1.b != card2.b) {
                    continue;
                }

                Vector<Card2> tmpVec = new Vector<>();
                for(int k = 0; k < cards.size(); k++) {
                    if(k != i && k != j) {
                        tmpVec.add(cards.get(k));
                    }
                }

                int tmpResult = dfs(tmpVec, depth + 1);

                //自分の一手によって勝ちを確定させられる場合
                if(takahashiTurn && tmpResult == T_WIN) {
                    history.put(vecStr, T_WIN);
                    return T_WIN;
                }

                if(!takahashiTurn && tmpResult == A_WIN) {
                    history.put(vecStr, A_WIN);
                    return A_WIN;
                }
            }
        }

        //ここまで来るということは勝ちを確定させる一手が無かったということ。負けが確定。
        if(takahashiTurn) {
            history.put(vecStr, A_WIN);
            return A_WIN;
        }

        else {
            history.put(vecStr, T_WIN);
            return T_WIN;
        }
    }

    static String vecToString(Vector<Card2> vec) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < vec.size(); i++) {
            sb.append(vec.get(i).a+","+vec.get(i).b+",");
        }

        return sb.toString();
    }

    static int pair (Vector<Card2> cards, boolean flip) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for(int i = 0; i < cards.size(); i++) {
            int key = flip ? cards.get(i).b : cards.get(i).a;

            map.merge(key, 1, (n1, n2) -> n1 + 1);

            if(map.get(key) == 2) {
                map.put(key, 0);
                result++;
            }
        }

        return result;
    }
}

class Card2 {
    int a;
    int b;

    Card2(int a, int b) {
        this.a = a;
        this.b = b;
    }
}