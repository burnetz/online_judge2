package atcoder.abc402;


import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Food[] foods = new Food[m];

        for(int i = 0; i < m; i++) {
            foods[i] = new Food();

            int k = sc.nextInt();

            for(int j = 0; j < k; j++) {
                foods[i].ingredients.add(sc.nextInt() - 1);
            }
        }

        int[] ingredients = new int[n];
        for(int i = 0; i < n; i++) {
            ingredients[sc.nextInt() - 1] = i + 1;
        }

        for(int i = 0; i < m; i++) {
            int tmpDay = 0;
            for(int j = 0; j < foods[i].ingredients.size(); j++) {
                tmpDay = Math.max(tmpDay, ingredients[foods[i].ingredients.get(j)]);
            }

            foods[i].day = tmpDay;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.day));

        for(int i = 0; i < m; i++) {
            pq.add(foods[i]);
        }

        for(int i = 1; i <= n; i++) {
            while(!pq.isEmpty() && pq.peek().day <= i) {
                pq.remove();
            }

            System.out.println(m - pq.size());
        }

    }
}

class Food {
    Vector<Integer> ingredients = new Vector<>();
    int day = Integer.MAX_VALUE;

}

