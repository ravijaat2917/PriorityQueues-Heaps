import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maximumSumPairs {

    public static void main(String args[]) {
        //below two ArrayList are used to store the given input
        ArrayList<Integer> ArrayL1 = new ArrayList<Integer>();
        ArrayList<Integer> ArrayL2 = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        int n, i;

        // size of ArrayL1 = size of ArrayL2 = n
        n = in.nextInt();

        for (i = 0; i < n; i++) {
            ArrayL1.add(in.nextInt());
        }
        for (i = 0; i < n; i++) {
            ArrayL2.add(in.nextInt());
        }
        in.close();
        fun(ArrayL1, ArrayL2 , n);
    }

        //write your code here
        public static void fun(ArrayList<Integer> ArrayL1 , ArrayList<Integer> ArrayL2 , int n){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for( int i=0 ; i<n ; i++){
            for( int j=0 ; j<n ; j++){
                priorityQueue.add(-1 * ( ArrayL1.get(i) + ArrayL2.get(j) ));
            }
        }
        while( n > 0){
            System.out.println(-1 * (priorityQueue.poll() ));
            n--;
        }
    }
}