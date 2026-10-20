
package atcoder.abc480;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] names = new String[n];
        for(int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int votes[] = new int[n];
loop1:        for(int i = 0; i < m; i++) {
            String tmpName = sc.next();

            for(int j = 0; j < n; j++) {
                if(tmpName.equals(names[j])) {
                    votes[j]++;
                    continue loop1;
                }
            }

            int similarIndex = -1;
            for(int j = 0; j < n; j++) {
                if(tmpName.length() == names[j].length()) {
                    int diffCount = 0;
                    for(int k = 0; k < tmpName.length(); k++) {
                        if(tmpName.charAt(k) != names[j].charAt(k)) {
                            diffCount++;
                        }
                    }

                    if(diffCount == 1) {
                        if(similarIndex >= 0) {
                            continue loop1;
                        }
                        else {
                            similarIndex = j;
                        }
                    }
                }
            }

            if(similarIndex >= 0) {
                votes[similarIndex]++;
            }

        }

        for(int i = 0; i < n; i++) {
            System.out.println(votes[i]);
        }

    }
}