import java.util.*;

public class sortNearlySortedArray {

    private static void sortArray(int[] arr, int k) {

        // Write code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i=0 ; i<arr.length ; i++){
            pq.add(arr[i]);
        }
        for( int i=0 ; i<arr.length ; i++ ){
            arr[i] = pq.poll();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);
        sc.close();
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}