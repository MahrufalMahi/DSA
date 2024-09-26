import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr){

        for(int i = 0; i < arr.length - 1; i++){

            for(int j = 0; j< arr.length - i -1; j++){

                if(arr[j] > arr[j + 1]){

                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }

        }
    }


    public static void main(String[] args) {

        int[] testArray = {34, 67, 23, 78, 12, 90, 56, 43, 98, 21, 45, 66, 53, 72, 29, 14, 87, 32, 9, 61, 17, 80, 25, 38, 99};
        System.out.println("Before sorting : ");
        System.out.println(Arrays.toString(testArray));
        bubbleSort(testArray);
        System.out.println("After sorting : ");
        System.out.println(Arrays.toString(testArray));

        
    }
    
}
