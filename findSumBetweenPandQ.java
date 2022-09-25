import java.util.*;

public class findSumBetweenPandQ {

    public static int sumBetweenPthToQthSmallestElement(int[] arr, int p, int q) {

        // Write code here
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < q - 1 && i >= p) {
                count = count + arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();
        System.out.println(sumBetweenPthToQthSmallestElement(arr, p, q));
    }
}