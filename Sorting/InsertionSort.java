import java.util.Arrays;

public class InsertionSort {


    public static void insertionSort(int arr[]){

        for(int i = 1; i < arr.length; i++){

            int j = i-1;
            int outSideSortedArray = arr[i];

            while(j >= 0 && arr[j] > outSideSortedArray){

                arr[j+1] = arr[j];
                j--;

            }
            arr[j+1] = outSideSortedArray;
        }

    }

  

    public static void main(String[] args) {
        
         int[] testArray = {34, 67, 23, 78, 12, 90, 56, 43, 98, 21, 45, 66, 53, 72, 29, 14, 87, 32, 9, 61, 17, 80, 25, 38, 99};
        System.out.println("Before sorting : ");
        System.out.println(Arrays.toString(testArray));
        insertionSort(testArray);
        System.out.println("After sorting : ");
        System.out.println(Arrays.toString(testArray));
    }
    
}
