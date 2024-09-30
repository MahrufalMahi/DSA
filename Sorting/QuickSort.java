/* package Sorting; */

import java.util.Arrays;

public class QuickSort{

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low;
        int j = low;
        

        while(i <= high){

            if(arr[i] > pivot){
              
                i++;
            }else{

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }

        return j-1;
    }


    public static void quickSort(int arr[], int low, int high){

        if(low >= high){
            return;
        }
    
    int partIndex = partition(arr, low, high);
    quickSort(arr, low, partIndex -1);
    quickSort(arr, partIndex + 1, high);

    }
    public static void main(String[] args){

        int[] intArray = {12, 34, 56, 78, 90, 23, 45, 67, 89, 10, 22, 33, 44, 55, 66};
        System.out.println(Arrays.toString(intArray));
        quickSort(intArray, 0, intArray.length-1);
        System.out.println(Arrays.toString(intArray));


    }
}