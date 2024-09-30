/* package Random; */
import java.util.Arrays;
public class PartitionArray{

 
    public static void partition(int arr[], int pivot){

        int i = 0;
        int j = 0;

        while (i < arr.length) {
            
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
    }

    public static void main(String[] args){

    int[] intArray = {12, 34, 56, 78, 90, 23, 45, 67, 89, 10, 22, 33, 44, 55, 66};
    System.out.println(Arrays.toString(intArray));
    partition(intArray, 33);
    System.out.println(Arrays.toString(intArray));




    }
}