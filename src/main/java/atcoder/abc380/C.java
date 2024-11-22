package atcoder.abc380;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        String str = sc.next();

        Vector<Cluster> vec = new Vector<>();

        int clusterOne = 0;
        for(int i = 0; i < n; i++) {
            char type = str.charAt(i);

            if(vec.size() == 0 || vec.lastElement().type != type) {
                vec.add(new Cluster(type));

                if(type == '1') {
                    clusterOne++;

                    if(clusterOne == k) {
                        vec.lastElement().count = 0;
                        vec.get(vec.size() - 3).count++;
                    }
                }
            }
            else {
                vec.lastElement().count++;

                if(type == '1' && clusterOne == k) {
                    vec.lastElement().count = 0;
                    vec.get(vec.size() - 3).count++;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < vec.size(); i++) {
            Cluster cluster = vec.get(i);

            for(int j = 0; j < cluster.count ; j++) {
                sb.append(cluster.type);
            }
        }

        System.out.println(sb);
    }
}

class Cluster {
    char type;
    int count = 1;

    Cluster(char type) {
        this.type = type;
    }
}