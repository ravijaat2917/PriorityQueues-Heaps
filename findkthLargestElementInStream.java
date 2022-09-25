import java.util.*;

public class findkthLargestElementInStream {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int stream[] = new int[n];

        for (int i = 0; i < n; i++) {

            stream[i] = sc.nextInt();

        }
        sc.close();
        fun(stream, k);
    }

    private static void fun(int[] array, int k) {
        PriorityQueue < Integer > pq = new PriorityQueue < > ();
        Queue < Integer > list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (i < k - 1) {
                System.out.println("None");
                pq.add(-1 * array[i]);
            } else {
                int count = 1;
                pq.add(-1 * array[i]);
                while (count < k) {
                    list.add(pq.poll());
                    count++;
                }
                System.out.println(k + " largest number is " + (-1 * pq.peek()));
                while (!list.isEmpty()) {
                    pq.add(list.poll());
                }
            }
        }
    }
}