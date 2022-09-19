import java.util.*;

class mergeKSortedLinkedList {
    
    

    // Driver program to test above
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        // Number of linked lists
        int k = in.nextInt();

        // Number of elements in each linked list
        int n = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        

        //write your code here
       for( int i=0 ; i<k*n ; i++){
        pq.add(in.nextInt());
       }
       in.close();

       while(!pq.isEmpty()){
        System.out.print(pq.poll()+" ");
       }
    }
}
