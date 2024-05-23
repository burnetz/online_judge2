package atcoder.abc354;

import java.util.*;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Card[] cards = new Card[n];
        for(int i = 0; i < n; i++) {
            cards[i] = new Card(i + 1, sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(cards);

        List<Card> list = new ArrayList<>();

        int prevCost = -1;
        //残るカードをattack順に並べるとcostが単調増加になる。
        //また、一番attackが高いカードは必ず最終的に残るので
        //attackが高い方から順に見ていけばよい。
        for(int i = 0; i < n; i++) {
            if(list.isEmpty() || cards[i].cost <= prevCost) {
                list.add(cards[i]);
                prevCost = cards[i].cost;
            }
        }

        list.sort(Comparator.comparingInt(a -> a.id));
        System.out.println(list.size());
        list.stream().forEach(e -> System.out.print(e.id + " "));


    }
}

class Card implements Comparable<Card> {
    int id;
    int attack;
    int cost;

    Card(int id, int attack, int cost) {
        this.id = id;
        this.attack = attack;
        this.cost = cost;
    }


    @Override
    public int compareTo(Card c) {
        return c.attack - this.attack != 0 ? c.attack - this.attack : this.cost - c.cost;
    }
}