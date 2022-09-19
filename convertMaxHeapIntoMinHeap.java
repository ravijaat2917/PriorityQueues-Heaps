import java.util.Arrays;
import java.util.Scanner;

class convertMaxHeapIntoMinHeap{
  
    public static int leftchild(int i) {   //Get index of left child at index i
        return (2*i+1);
    }

    public static int rightchild(int i) {   //Get index of right child at index i
        return (2*i+2);
    }

    private static void heapify(int[] arr, int index, int n) {
       
       int smallest = index;
        int l = 2*smallest +1;
        int r = 2*smallest + 2;

        

        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if (smallest != index) {
            swap(arr, index, smallest);
            heapify( arr, smallest , n);
        }

    }
     public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     public static void buildHeap(int[] arr){
        int i = arr.length;
        for( int j= (i/2)-1 ; j>=0 ; j--){
            heapify(arr, j, i);
        }
    }

    public static int[] getArrayInput(int size, Scanner scanner) {
       int array[] = new int[size];
       for (int i = 0; i < size; i++) {
           array[i] = scanner.nextInt();
       }
       return array;
   }

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int sizeArray1 = scanner.nextInt();
       int arr[] = getArrayInput(sizeArray1, scanner);

        buildHeap(arr);

        System.out.println(Arrays.toString(arr));
    }
}