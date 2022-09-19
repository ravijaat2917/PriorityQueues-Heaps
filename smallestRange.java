import java.util.*;
    class smallestRange {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            sc.close();
            findSmallestRange(arr, k);
        }
 
        // A min heap node
        static class Node {
            // The element to be stored
            int ele;
     
            // index of the list from which
            // the element is taken
            int i;
     
            // index of the next element
            // to be picked from list
            int j;
     
            Node(int a, int b, int c)
            {
                this.ele = a;
                this.i = b;
                this.j = c;
            }
        }
     
        // A class for Min Heap
        static class MinHeap {
            Node[] harr; // array of elements in heap
            int size; // size of min heap
     
            // Constructor: creates a min heap
            // of given size
            MinHeap(Node[] arr, int size)
            {
                this.harr = arr;
                this.size = size;
                int i = (size - 1) / 2;
                while (i >= 0) {
                    MinHeapify(i);
                    i--;
                }
            }
     
            // to get index of left child
            // of node at index i
            int left(int i) { return 2 * i + 1; }
     
            // to get index of right child
            // of node at index i
            int right(int i) { return 2 * i + 2; }
     
            // to heapify a subtree with
            // root at given index
            void MinHeapify(int i)
            {
                int l = left(i);
                int r = right(i);
                int small = i;
     
                if (l < size && harr[l].ele < harr[i].ele)
                    small = l;
     
                if (r < size && harr[r].ele < harr[small].ele)
                    small = r;
     
                if (small != i) {
                    swap(small, i);
                    MinHeapify(small);
                }
            }
     
            void swap(int i, int j)
            {
                Node temp = harr[i];
                harr[i] = harr[j];
                harr[j] = temp;
            }
     
            // to get the root
            Node getMin() { return harr[0]; }
     
            // to replace root with new node x
            // and heapify() new root
            void replaceMin(Node x)
            {
                harr[0] = x;
                MinHeapify(0);
            }
        }
     
        // This function takes an k sorted lists
        // in the form of 2D array as an argument.
        // It finds out smallest range that includes
        // elements from each of the k lists.
        static void findSmallestRange(int[][] arr, int K)
        {
            int range = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int start = -1, end = -1;
     
            int N = arr[0].length;
     
            // Create a min heap with K heap nodes.
            // Every heap node has first element of an list
            Node[] arr1 = new Node[K];
            for (int i = 0; i < K; i++) {
                Node node = new Node(arr[i][0], i, 1);
                arr1[i] = node;
     
                // store max element
                max = Math.max(max, node.ele);
            }
     
            // Create the heap
            MinHeap mh = new MinHeap(arr1, K);
     
            // Now one by one get the minimum element
            // from min heap and replace it with
            // next element of its list
            while (true) {
                // Get the minimum element and
                // store it in output
                Node root = mh.getMin();
     
                // update min
                min = root.ele;
     
                // update range
                if (range > max - min + 1) {
                    range = max - min + 1;
                    start = min;
                    end = max;
                }
     
                // Find the next element that will
                // replace current root of heap.
                // The next element belongs to same
                // list as the current root.
                if (root.j < N) {
                    root.ele = arr[root.i][root.j];
                    root.j++;
     
                    // update max element
                    if (root.ele > max)
                        max = root.ele;
                }
                // break if we have reached
                // end of any list
                else
                    break;
     
                // Replace root with next element of list
                mh.replaceMin(root);
            }
            System.out.println("Smallest range is : [" + start + ", " + end + "]");
        }
    }