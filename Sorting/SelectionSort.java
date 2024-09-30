import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int arr[]){

        for(int i = 0; i < arr.length; i++){

            int min = Integer.MAX_VALUE;
            int minIndex = i;

            for(int j = i + 1; j < arr.length; j++){

                if(arr[j] < min){

                    min = arr[j];
                    minIndex = j;
                }
            }

            if(arr[i] > arr[minIndex]){

                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

            }
        }
    }


public static void main(String[] args) {

        int[] testArray = {34, 67, 23, 78, 12, 90, 56, 43, 98, 21, 45, 66, 53, 72, 29, 14, 87, 32, 9, 61, 17, 80, 25, 38, 99};
        System.out.println("Before sorting : ");
        System.out.println(Arrays.toString(testArray));
        selectionSort(testArray);
        System.out.println("After sorting : ");
        System.out.println(Arrays.toString(testArray));
    
}
    
}
