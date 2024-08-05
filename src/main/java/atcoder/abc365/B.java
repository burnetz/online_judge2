package atcoder.abc365;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Element[] elements = new Element[n];
        for(int i = 0; i < n; i++) {
            elements[i] = new Element(i + 1, a[i]);
        }

        Arrays.sort(elements);

        System.out.println(elements[n - 2].index);
    }
}

class Element implements Comparable<Element>{
    int index;
    int value;

    Element(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.value, o.value);
    }
}