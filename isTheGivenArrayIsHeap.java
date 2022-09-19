
import java.util.*;
class isTheGivenArrayIsHeap{
    public static boolean  isHeap(int[] arr,  int n){
    //Write your code here
    //Check if the array element is less than it's child element in the array,
    //and if they are less return false else return true
    boolean result = true;
    for( int i=1 ; i<n ; i++){
        if( arr[2*i+1] < n){
        if( arr[2*i] > arr[i] || arr[2*i + 1] >arr[i] ){
            return false;
        }else{
            return true;
        }
    }
    }
    return result;
}
public static int[] getArrayInput(int size, Scanner scanner) {
       int array[] = new int[size];
       for (int i = 0; i < size; i++) {
           array[i] = scanner.nextInt();
       }
       return array;
   }

	public static void main (String[] args) {
	 Scanner scanner = new Scanner(System.in);
       int sizeArray1 = scanner.nextInt();
       int arr[] = getArrayInput(sizeArray1, scanner);
	    int n = arr.length;
	    String x = isHeap(arr, n)? "Yes": "No";
 
		System.out.println(x);
	}
	
}
