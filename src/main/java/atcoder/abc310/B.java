package atcoder.abc310;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Set<Integer> func[] = new HashSet[n];
        int prices[] = new int[n];

        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
            int num = sc.nextInt();
            func[i] = new HashSet<Integer>();

            for(int j = 0 ; j < num ; j++){
                func[i].add(sc.nextInt());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(prices[i] < prices[j]){
                    continue;
                }

                boolean hasAllFunc = func[i].stream().allMatch(func[j]::contains);
                int finalI = i;
                boolean hasUniqueFunc = func[j].stream().anyMatch(a -> !(func[finalI].contains(a)));

                if(hasAllFunc && (prices[i] > prices[j] || hasUniqueFunc)){
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
