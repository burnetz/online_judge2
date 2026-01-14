package atcoder.abc438;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Stack<Puyo> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()) {
                stack.add(new Puyo(a[i], 1));
            }
            else {
                Puyo tmp = stack.peek();

                if(tmp.value != a[i]) {
                    stack.add(new Puyo(a[i], 1));
                }
                else if(tmp.amount < 3){
                    stack.add(new Puyo(a[i], tmp.amount + 1));
                }
                else {
                    for(int j = 0; j < 3; j++) {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(stack.size());
    }
}

class Puyo {
    int value;
    int amount;

    public Puyo(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }
}