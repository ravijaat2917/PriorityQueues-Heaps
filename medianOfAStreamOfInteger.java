import java.util.*;

public class medianOfAStreamOfInteger {

    
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[]= new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }
        streamMed(array ,n);
        in.close();
    }
    public static void streamMed(int A[], int N)
    {
        // Declaring two min heap
        PriorityQueue<Double> g = new PriorityQueue<>();
        PriorityQueue<Double> s = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {

            // Negation for treating it as max heap
            s.add(-1.0 * A[i]);
            g.add(-1.0 * s.poll());
            if (g.size() > s.size())
                s.add(-1.0 * g.poll());

            if (g.size() != s.size())
                System.out.println(-1.0 * s.peek());
            else
                System.out.println((g.peek() - s.peek()) / 2);
        }
    }
}