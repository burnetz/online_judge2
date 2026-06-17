package atcoder.abc423;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int lock[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        boolean visited[] = new boolean[n + 1];
        visited[0] = true;
        visited[n] = true;

        int left = 0;
        int right = n;
        for(int i = 0; i < n; i++) {
            if(lock[left] == 0) {
                left++;
            }
            if(lock[right - 1] == 0) {
                right--;
            }

            visited[left] = true;
            visited[right] = true;
        }

        int count = 0;
        for(int i = 0; i <= n; i++) {
            if(!visited[i]) {
                count++;
            }
        }

        System.out.println(count);

    }
}