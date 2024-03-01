package library.dataset;

import java.util.Arrays;

public class RSQManager {
    private int[] array;
    private int n;
    private final int INIT = 0;
    private int origin = 1;

    public RSQManager(int n){
        this.n = n;
        array = new int[n + origin];

        Arrays.fill(array, INIT);
    }

    public void update(int index, int num){
        array[index] = num;
    }

    public void add(int index, int num){
        array[index] += num;
    }

    public int findMin(int s, int t){
        int min = Integer.MAX_VALUE;

        for(int i = s ; i <= t; i++){
            if(min > array[i]){
                min = array[i];
            }
        }

        return min;
    }

    public long getSum(int s, int t){
        long sum = 0;

        for(int i = s; i <= t ; i++){
            sum += array[i];
        }

        return sum;
    }
}
