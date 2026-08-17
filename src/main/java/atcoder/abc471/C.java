
package atcoder.abc471;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        PriorityQueue<Integer> positive = new PriorityQueue<>();
        PriorityQueue<Integer> negative = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));

        for(int i = 0; i < n; i++) {
            if(a[i] > 0) {
                positive.add(a[i]);
            }
            else {
                negative.add(a[i]);
            }
        }

        long result = 0;
        int currentPos = 0;
        while(!positive.isEmpty() || !negative.isEmpty()) {
            if(positive.isEmpty()) {
                int tmp = negative.poll();
                result += currentPos - tmp;
                currentPos = tmp;
            }
            else if(negative.isEmpty()) {
                int tmp = positive.poll();
                result += tmp - currentPos;
                currentPos = tmp;
            }
            else {
                int tmpPositive = positive.peek();
                int tmpNegative = negative.peek();

                int rightDist = tmpPositive - currentPos;
                int leftDist = currentPos - tmpNegative;

                if(rightDist < leftDist) {
                    positive.poll();
                    result += rightDist;
                    currentPos = tmpPositive;
                }
                else {
                    negative.poll();
                    result += leftDist;
                    currentPos = tmpNegative;
                }
            }
        }

        System.out.println(result);

    }
}